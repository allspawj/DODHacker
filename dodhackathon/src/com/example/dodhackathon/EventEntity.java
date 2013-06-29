package com.example.dodhackathon;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import com.kinvey.java.model.KinveyMetaData;

public class EventEntity extends GenericJson {
	public EventEntity()
	{
		
	}
	@Key("_id")
     String id; 
	@Key("RATION")
	 String RATION;
	@Key("MENU")
	String MENU;
	@Key
     String ITEMTYPE;
	@Key
     String ITEM;
    @Key
     String WEIGHT;
    @Key 
    String CALORIES;
    @Key
     String TOTALFAT_G;
    @Key
     String TOTALFAT_DV;
    @Key
     String SATURATEDFAT_G;
    @Key
     String SATURATEDFAT_DV;
    @Key
     String TRANSFAT_G;
    @Key
     String CHOLESTEROL_MG;
    @Key
     String CHOLESTEROL_DV;
    @Key
     String SODIUM_MG;
    @Key
     String SODIUM_DV;
    @Key
     String POTASSIUM_MG;
    @Key
     String CARBOHYDRATES_G;
    @Key
     String CARBOHYDRATES_DV;
    @Key
     String DIETARYFIBER_G;
    @Key
     String DIETARYFIBER_DV;
    @Key
     String SUGARS_G;
    @Key
     String PROTEIN_G;
    @Key
     String VITAMINA_IU;
    @Key
     String VITAMINA_DV;
    @Key
     String VITAMINC_MG;
    @Key
     String VITAMINC_DV;
    @Key
     String CALCIUM_MG;
    @Key
     String CALCIUM_DV;
    @Key
     String IRON_MG;
    @Key
     String IRON_DV;
    @Key
     String VITAMINE_MG;
    @Key
     String THIAMIN_MG;
    @Key
     String RIBOFLAVIN_MG;
    @Key
     String NIACIN_MG;
    @Key
     String VITAMINB6_MG;
    @Key
     String FOLICACID_MCG;
    @Key
     String VITAMINB12_MCG;
    @Key
     String PHOSPHOROUS_MG;
    @Key
     String MAGNESIUM_MG;
    @Key
     String ZINC_MG;
    @Key
     String SELENIUM_MCG;
    @Key("_kmd")
     KinveyMetaData meta; // Kinvey metadata, OPTIONAL
    @Key("_acl")
     KinveyMetaData.AccessControlList acl; //Kinvey access control, OPTIONAL
    
    public String getId()
    {
    	return id;
    }
    
   }