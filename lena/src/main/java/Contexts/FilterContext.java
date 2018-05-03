package Contexts;
import PageObjects.ResultsPageGlue;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class FilterContext {

    public static  void filterRange(ResultsPageGlue products, int minPriceToSet, int maxPriceToSet){

       products.setMinPrice(minPriceToSet);
       products.setMaxPrice(maxPriceToSet);
    }

    public void filterCountries (ResultsPageGlue products, List<String> countries){

        for(String countryToSelect : countries){
            products.country.select(countryToSelect);
        }
    }

    public static void filterProducers ( ResultsPageGlue products, List<String> producers){

        for(String producerToSelect : producers){
           products.producer.select(producerToSelect);
        }
    }

    public static void filterProducer ( ResultsPageGlue products, String producerToSelect){

            products.producer.select(producerToSelect);

    }

    public void filterOsnova ( ResultsPageGlue products, List<String>osnovas){

        for(String osnovaToSelect : osnovas){
            products.producer.select(osnovaToSelect);
        }
    }
    public void filterType(ResultsPageGlue products, List<String>types){

        for(String typeToSelect : types){
            products.producer.select(typeToSelect);
        }
    }
    public void assertMin(ResultsPageGlue products, int minToBe){

        int currMin = Integer.parseInt(products.minPrice.getText());
        assertTrue(minToBe <= currMin);
    }

    public void assertMax (ResultsPageGlue products, int maxToBe){

        int currMax = Integer.parseInt(products.minPrice.getText());
        assertTrue(maxToBe >= currMax);
    }

    public static void assertProducer(ResultsPageGlue products, String producerToBeSelected){
        assertTrue(products.producer.isSelected(producerToBeSelected) );
    }

    public static void assertRangePrice ( ResultsPageGlue products, int min, int max){

        int currMin = products.getMinPrice();
        int currMax = products.getMaxPrice();
        assertTrue((max >= currMax)&&(min <= currMin));
    }

}
