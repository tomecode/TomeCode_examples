package com.tomecode.oer11g.poc.metadata;

import java.io.File;
import java.net.URL;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.apache.axis.client.Stub;

import com.flashline.registry.openapi.entity.Asset;
import com.flashline.registry.openapi.entity.AuthToken;
import com.flashline.registry.openapi.entity.MetadataEntrySummary;
import com.flashline.registry.openapi.query.AssetCriteria;
import com.flashline.registry.openapi.service.v300.FlashlineRegistry;
import com.flashline.registry.openapi.service.v300.FlashlineRegistryServiceLocator;

/**
 * simple code that shows how to upload(load) custom metadata (XML, XSD, WSDL,
 * etc.) to asset in OER 11g
 * 
 * 
 * @author Tomecode.com:
 * 
 * 
 */
public final class Oer11gUploadAssetMetadata {

	public static final void main(String[] arg) throws Exception {

		
		URL oerURL=new URL("http://localhost:17200/oer/services/FlashlineRegistry");
		String oerUser ="admin";
		String oerPass= "admin1234";
		
		// ########################################################
		//
		// Connect to OER 11g
		FlashlineRegistry repository = new FlashlineRegistryServiceLocator().getFlashlineRegistry(oerURL);
		AuthToken authToken = repository.authTokenCreate(oerUser, oerPass);

		
		
		// ########################################################
		//
		// find target service (e.g.: tomeSampleAssetWithCustomMetadata)
		AssetCriteria assetCriteria = new AssetCriteria();
		//
		//TODO: to change an existing ASSET -->tomeSampleAssetWithCustomMetadata
		//
		assetCriteria.setNameCriteria("tomeSampleAssetWithCustomMetadata");
		Asset[] assets = repository.assetQuery(authToken, assetCriteria);
		if( assets.length==0){
			throw new RuntimeException("Asset not found in OER!");
		}
		Asset asset = assets[0];

		// ########################################################
		//
		// find target file (in this case is WSDL) and setup attachment
		File f = new File(Oer11gUploadAssetMetadata.class.getResource("demoWsdl.wsdl").toURI().getPath());
		Stub stub = (Stub) repository;
		stub._setProperty("attachment_encapsulation_format", "axis.attachment.style.mime");
		FileDataSource localFileDataSource = new FileDataSource(f);
		DataHandler localDataHandler = new DataHandler(localFileDataSource);
		stub.addAttachment(localDataHandler);

		// ########################################################
		//
		// setup metada for target file
		MetadataEntrySummary entrySummary = new MetadataEntrySummary();
		entrySummary.setName(f.getName());
		entrySummary.setEntryType("internal.artifact.store");//
		entrySummary.setEntityID(asset.getID());

		// upload file with metadata to OER
		repository.assetMetadataCreateDIME(authToken, entrySummary);

		// ########################################################
		//
		// find all uploaded metadata in target asset
		MetadataEntrySummary[] entrySummaries = repository.assetMetadataRead(authToken, asset.getID());

		//
		//
		for (MetadataEntrySummary metadataEntrySummary : entrySummaries) {
			// accept uploaded metada
			repository.assetMetadataAccept(authToken, metadataEntrySummary);
		}

		// reading metadata programmatically
		// repository.assetMetadataReadDIME(authToken, entrySummaries[0]);
		// ...
	}
}
