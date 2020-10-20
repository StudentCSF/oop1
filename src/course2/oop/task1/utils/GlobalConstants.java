package course2.oop.task1.utils;

import course2.oop.task1.buyer.BuyerLimitations;
import course2.oop.task1.products.*;
import course2.oop.task1.products.drink.BaseDrink;
import course2.oop.task1.products.bread.BaseBread;
import course2.oop.task1.products.chem.BaseHouseholdChemicals;
import course2.oop.task1.products.green_grocery.BaseGreenGrocery;
import course2.oop.task1.products.grocery.BaseGrocery;
import course2.oop.task1.products.meat.BaseMeat;
import course2.oop.task1.products.milk.BaseMilkProducts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GlobalConstants {

   /* public static final List<Class<? extends BaseProduct>> PRODUCTS = new ArrayList<>(Arrays.asList(
            BaseDrink.class,
            BaseBread.class,
            BaseGreenGrocery.class,
            BaseGrocery.class,
            BaseHouseholdChemicals.class,
            BaseMeat.class,
            BaseMilkProducts.class
    ));*/

    public static final List<BuyerLimitations> BUYER_LIMITATIONS = new ArrayList<>(Arrays.asList(
            BuyerLimitations.CHEM,
            BuyerLimitations.MEAT,
            BuyerLimitations.MILK,
            BuyerLimitations.VaF
    ));

    public static final List<MeasureUnit> MEASURE_UNITS = new ArrayList<>(Arrays.asList(
            MeasureUnit.kg,
            MeasureUnit.liters,
            MeasureUnit.pcs
    ));
}
