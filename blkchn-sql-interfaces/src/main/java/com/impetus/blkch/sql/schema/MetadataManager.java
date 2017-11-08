package com.impetus.blkch.sql.schema;

public class MetadataManager {

	private static Schema metadata = null;
	
	public static synchronized void setMetadata(Schema metadata) {
		if(MetadataManager.metadata == null) {
			MetadataManager.metadata = metadata;
		}
	}
	
	public static Schema getMetadata() {
		if(metadata == null) {
			throw new RuntimeException("Tried to access uninitialized metadata");
		}
		return metadata;
	}
	
}
