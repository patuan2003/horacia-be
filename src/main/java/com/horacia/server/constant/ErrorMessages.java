package com.horacia.server.constant;

public final class ErrorMessages {

    private ErrorMessages() {
    }

    public static final String PRODUCT_NOT_FOUND = "Product with id %s not found";
    public static final String BRAND_NOT_FOUND = "Brand with id %s not found";
    public static final String MOVEMENT_NOT_FOUND = "Movement with id %s not found";
    public static final String GLASS_NOT_FOUND = "Glass with id %s not found";
    public static final String WATER_RESISTANCE_NOT_FOUND = "WaterResistance with id %s not found";

    public static final String PRODUCT_NAME_NOT_EMPTY = "Product name must not be empty";
    public static final String PRODUCT_MODEL_CODE_NOT_EMPTY = "Model code must not be empty";
    public static final String PRODUCT_DIAMETER_REQUIRED = "Diameter is required";
    public static final String PRODUCT_THICKNESS_REQUIRED = "Thickness is required";

    public static final String BRAND_ID_REQUIRED = "Brand ID is required";
    public static final String MOVEMENT_ID_REQUIRED = "Movement ID is required";
    public static final String GLASS_ID_REQUIRED = "Glass ID is required";
    public static final String WATER_RESISTANCE_ID_REQUIRED = "Water resistance ID is required";

}
