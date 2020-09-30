package course2.oop.task1.utils;

import course2.oop.task1.buyer.BuyerLimitations;
import course2.oop.task1.products.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GlobalConstants {

    public static final List<Class<? extends BaseProduct>> PRODUCTS = new ArrayList<>(Arrays.asList(
            Alcohol.class,
            Bread.class,
            GreenGrocery.class,
            Grocery.class,
            HouseholdChemicals.class,
            Meat.class,
            MilkProducts.class
    ));

    public static final List<BuyerLimitations> BUYER_LIMITATIONS = new ArrayList<>(Arrays.asList(
            BuyerLimitations.CHEM,
            BuyerLimitations.MEAT,
            BuyerLimitations.MILK,
            BuyerLimitations.VaF
    ));

    public static final List<MeasureUnit> MEASURE_UNITS = new ArrayList<>(Arrays.asList(
            MeasureUnit.KG,
            MeasureUnit.LITERS,
            MeasureUnit.PCS
    ));
}
