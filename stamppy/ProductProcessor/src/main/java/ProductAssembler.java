package main.java;



import java.io.File;

public class ProductAssembler {
	
	private static final String INIT_FILE ="resources/outputProject/stamppy/stamppyProject-businessLogic/src/main/java/org/stamppyProject/businessLogic/InitBean.java";
	
	private static final String PARENT_POM ="resources/outputProject/stamppy/pom.xml";
	
	private static final String EAR_POM ="resources/outputProject/stamppy/stamppyProject-ear/pom.xml";
	
	private static final String STAMP_BEAN ="resources/outputProject/stamppy/stamppyProject-businessLogic/src/main/java/org/stamppyProject/businessLogic/business/stamp/StampBean.java";
	
	public static void createProduct(FeatureFileConverter features, String outputFolder){
		
		try {
			FileUtils.deleteExistingProject();
			FileUtils.copySourceProjec();
			if(features.isByArtist()){
				FileUtils.replaceFileContent("REPORT_SALES_ARTIST = Boolean.FALSE;", "REPORT_SALES_ARTIST = Boolean.TRUE;", INIT_FILE);
			}
			if(features.isCashOnDelivery()){
				FileUtils.replaceFileContent("CASH_ON_DELIVERY = Boolean.FALSE;", "CASH_ON_DELIVERY = Boolean.TRUE;", INIT_FILE);
			}
			if(features.isChangeAddress() && features.isChangePassword()){
				FileUtils.replaceFileContent("USER_BUILDER_STRATEGY = \"NOT_EMAIL_NOT_PASSWORD\";", "USER_BUILDER_STRATEGY = \"COMPLETE\";", INIT_FILE);
			}else if(features.isChangePassword()){
				FileUtils.replaceFileContent("USER_BUILDER_STRATEGY = \"NOT_EMAIL_NOT_PASSWORD\";", "USER_BUILDER_STRATEGY = \"NOT_EMAIL\";", INIT_FILE);
			}else if(features.isChangeAddress()){
				FileUtils.replaceFileContent("USER_BUILDER_STRATEGY = \"NOT_EMAIL_NOT_PASSWORD\";", "USER_BUILDER_STRATEGY = \"NOT_PASSWORD\";", INIT_FILE);
			}
			if(features.isColor()){
				FileUtils.copyFile(new File("resources/variability/aspects/AddProductColor.java"), 
						new File("resources/outputProject/stamppy/stamppyProject-businessLogic/src/main/java/org/stamppyProject/businessLogic/aspect/AddProductColor.java"));
			}

			if(features.isDesignsByArtist()){
				FileUtils.replaceFileContent("REPORT_DESIGN_ARTIST = Boolean.FALSE;", "REPORT_DESIGN_ARTIST = Boolean.TRUE;", INIT_FILE);
				
			}
			if(features.isRateDesigns()){
				FileUtils.replaceFileContent("RATE_DESIGNS = Boolean.FALSE;", "RATE_DESIGNS = Boolean.TRUE;", INIT_FILE);
				
			}
			if(features.isRateProducts()){
				FileUtils.replaceFileContent("RATE_PRODUCTS = Boolean.FALSE;", "RATE_PRODUCTS = Boolean.TRUE;", INIT_FILE);
			}
			if(features.isTwitter()){
				FileUtils.replaceFileContent("TWITTER = Boolean.FALSE;", "TWITTER = Boolean.TRUE;", INIT_FILE);
			}
			if(features.isFacebook()){
				FileUtils.replaceFileContent("FACEBOOK = Boolean.FALSE;", "FACEBOOK = Boolean.TRUE;", INIT_FILE);
			}
			if(features.isRating()){
				File srcFolder = new File("resources/variability/ratingReport-service");
		    	File destFolder = new File("resources/outputProject/stamppy/ratingReport-service");
				FileUtils.copyFolder(srcFolder, destFolder);
				FileUtils.replaceFileContent("<!--ratingReport-->", "<module>ratingReport-service</module>", PARENT_POM);
				FileUtils.replaceFileContent("<!--ratingReportModule-->", "<webModule><groupId>com.uniandes.hexagram</groupId><artifactId>ratingReport-service</artifactId></webModule>", EAR_POM);
				FileUtils.replaceFileContent("<!--ratingReportDependency-->", "<dependency><groupId>com.uniandes.hexagram</groupId><artifactId>ratingReport-service</artifactId><version>0.0.1-SNAPSHOT</version><type>war</type></dependency>", EAR_POM);
			}
			if(features.isSales()){
				File srcFolder = new File("resources/variability/salesReport-service");
		    	File destFolder = new File("resources/outputProject/stamppy/salesReport-service");
				FileUtils.copyFolder(srcFolder, destFolder);
				FileUtils.replaceFileContent("<!--salesReport-->", "<module>salesReport-service</module>", PARENT_POM);
				FileUtils.replaceFileContent("<!--salesReportModule-->", "<webModule><groupId>com.uniandes.hexagram</groupId><artifactId>salesReport-service</artifactId></webModule>", EAR_POM);
				FileUtils.replaceFileContent("<!--salesReportDependency-->", "<dependency><groupId>com.uniandes.hexagram</groupId><artifactId>salesReport-service</artifactId><version>0.0.1-SNAPSHOT</version><type>war</type></dependency>", EAR_POM);
			}
			if(features.isText()){
				FileUtils.copyFile(new File("resources/variability/aspects/AddProductText.java"), 
						new File("resources/outputProject/stamppy/stamppyProject-businessLogic/src/main/java/org/stamppyProject/businessLogic/aspect/AddProductText.java"));
			}
			if(features.isCreatePromo() || features.isUpdatePromo()){
				File srcFolder = new File("resources/variability/offers-service");
		    	File destFolder = new File("resources/outputProject/stamppy/offers-service");
				FileUtils.copyFolder(srcFolder, destFolder);
				FileUtils.replaceFileContent("<!--offers-->", "<module>offers-service</module>", PARENT_POM);
				FileUtils.replaceFileContent("<!--offersModule-->", "<webModule><groupId>com.uniandes.hexagram</groupId><artifactId>offers-service</artifactId></webModule>", EAR_POM);
				FileUtils.replaceFileContent("<!--offersDependency-->", "<dependency><groupId>com.uniandes.hexagram</groupId><artifactId>offers-service</artifactId><version>0.0.1-SNAPSHOT</version><type>war</type></dependency>", EAR_POM);
				FileUtils.copyFile(new File("resources/variability/annotations/OffersVariability.java"), 
						new File("resources/outputProject/stamppy/stamppyProject-businessLogic/src/main/java/org/stamppyProject/businessLogic/annotations/OffersVariability.java"));
				FileUtils.replaceFileContent("//importOfferVariability", "import org.stamppyProject.businessLogic.annotations.OffersVariability;", STAMP_BEAN);
				FileUtils.replaceFileContent("private Class ann = null;", "private Class ann = OffersVariability.class;", STAMP_BEAN);
	
				if(features.isCreatePromo()){
					FileUtils.replaceFileContent("//OffersVariabilitySave", "@OffersVariability", STAMP_BEAN);
				}
				
				if(features.isUpdatePromo()){
					FileUtils.replaceFileContent("//OffersVariabilityUpdate", "@OffersVariability", STAMP_BEAN);
				}
			}
			if(features.isPerformance()){
				FileUtils.copyFile(new File("resources/variability/aspects/AppLogAspect.java"), 
						new File("resources/outputProject/stamppy/stamppyProject-businessLogic/src/main/java/org/stamppyProject/businessLogic/aspect/AppLogAspect.java"));
			}
			
			System.out.println("runGenerator()");
			FileUtils.runEarGenerator();
			System.out.println("copyEar()");
			FileUtils.copyEar();
			FileUtils.copyFile(new File("resources/ear/stamppy.ear"), 
					new File(outputFolder+"/stamppy.ear"));
			System.out.println("END");
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
