package net.brianpowers.blsviewer.service;

import com.google.common.collect.ImmutableList;
import net.brianpowers.blsviewer.api.BlsRequestType;
import net.brianpowers.blsviewer.model.AreaItemCode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service to retrieve lists of valid codes for making requests to the BLS Data services.  Codelists are hard-coded for
 * now, but this should probably go to an external data-store as we support more requests.
 */
@Service
public class BlsCodesDao {

    private final ImmutableList<AreaItemCode> AREA_CODES_AVERAGE_PRICE;
    private final ImmutableList<AreaItemCode> ITEM_CODES_AVERAGE_PRICE;

    public BlsCodesDao() {
        AREA_CODES_AVERAGE_PRICE = ImmutableList.<AreaItemCode>builder()
                .add(new AreaItemCode("0000", "U.S. city average"))
                .add(new AreaItemCode("0100", "Northeast urban"))
                .add(new AreaItemCode("0200", "Midwest urban"))
                .add(new AreaItemCode("0300", "South urban"))
                .add(new AreaItemCode("0400", "West urban"))
                .add(new AreaItemCode("A101", "New York-Northern New Jersey-Long Island, NY-NJ-CT-PA"))
                .add(new AreaItemCode("A102", "Philadelphia-Wilmington-Atlantic City, PA-NJ-DE-MD"))
                .add(new AreaItemCode("A103", "Boston-Brockton-Nashua, MA-NH-ME-CT"))
                .add(new AreaItemCode("A104", "Pittsburgh, PA"))
                .add(new AreaItemCode("A105", "Buffalo-Niagara Falls, NY"))
                .add(new AreaItemCode("A106", "Scranton, PA"))
                .add(new AreaItemCode("A207", "Chicago-Gary-Kenosha, IL-IN-WI"))
                .add(new AreaItemCode("A208", "Detroit-Ann Arbor-Flint, MI"))
                .add(new AreaItemCode("A209", "St. Louis, MO-IL"))
                .add(new AreaItemCode("A210", "Cleveland-Akron, OH"))
                .add(new AreaItemCode("A211", "Minneapolis-St. Paul, MN-WI"))
                .add(new AreaItemCode("A212", "Milwaukee-Racine, WI"))
                .add(new AreaItemCode("A213", "Cincinnati-Hamilton, OH-KY-IN"))
                .add(new AreaItemCode("A214", "Kansas City, MO-KS"))
                .add(new AreaItemCode("A311", "Washington-Baltimore, DC-MD-VA-WV"))
                .add(new AreaItemCode("A315", "Washington, DC-MD-VA"))
                .add(new AreaItemCode("A316", "Dallas-Fort Worth, TX"))
                .add(new AreaItemCode("A317", "Baltimore, MD"))
                .add(new AreaItemCode("A318", "Houston-Galveston-Brazoria, TX"))
                .add(new AreaItemCode("A319", "Atlanta, GA"))
                .add(new AreaItemCode("A320", "Miami-Fort Lauderdale, FL"))
                .add(new AreaItemCode("A421", "Los Angeles-Riverside-Orange County, CA"))
                .add(new AreaItemCode("A422", "San Francisco-Oakland-San Jose, CA"))
                .add(new AreaItemCode("A423", "Seattle-Tacoma-Bremerton, WA"))
                .add(new AreaItemCode("A424", "San Diego, CA"))
                .add(new AreaItemCode("A425", "Portland-Salem, OR-WA"))
                .add(new AreaItemCode("A426", "Honolulu, HI"))
                .add(new AreaItemCode("A427", "Anchorage, AK"))
                .add(new AreaItemCode("A433", "Denver-Boulder-Greeley, CO"))
                .build();
        ITEM_CODES_AVERAGE_PRICE = ImmutableList.<AreaItemCode>builder()
                .add(new AreaItemCode("701111", "Flour, white, all purpose, per lb. (453.6 gm)"))
                .add(new AreaItemCode("701311", "Rice, white, long grain, precooked (cost per pound/453.6 grams)"))
                .add(new AreaItemCode("701312", "Rice, white, long grain, uncooked, per lb. (453.6 gm)"))
                .add(new AreaItemCode("701321", "Spaghetti (cost per pound/453.6 grams)"))
                .add(new AreaItemCode("701322", "Spaghetti and macaroni, per lb. (453.6 gm)"))
                .add(new AreaItemCode("702111", "Bread, white, pan, per lb. (453.6 gm)"))
                .add(new AreaItemCode("702112", "Bread, French, per lb. (453.6 gm)"))
                .add(new AreaItemCode("702211", "Bread, rye, pan (cost per pound/453.6 grams)"))
                .add(new AreaItemCode("702212", "Bread, whole wheat, pan, per lb. (453.6 gm)"))
                .add(new AreaItemCode("702213", "Bread, wheat blend, pan (cost per pound/453.6 grams)"))
                .add(new AreaItemCode("702221", "Rolls, hamburger (cost per pound/453.6 grams)"))
                .add(new AreaItemCode("702411", "Cupcakes, chocolate (cost per pound/453.6 grams)"))
                .add(new AreaItemCode("702421", "Cookies, chocolate chip, per lb. (453.6 gm)"))
                .add(new AreaItemCode("702611", "Crackers, soda, salted, per lb. (453.6 gm)"))
                .add(new AreaItemCode("703111", "Ground chuck, 100% beef, per lb. (453.6 gm)"))
                .add(new AreaItemCode("703112", "Ground beef, 100% beef, per lb. (453.6 gm)"))
                .add(new AreaItemCode("703113", "Ground beef, lean and extra lean, per lb. (453.6 gm)"))
                .add(new AreaItemCode("703211", "Chuck roast, USDA Choice, bone-in, per lb. (453.6 gm)"))
                .add(new AreaItemCode("703212", "Chuck roast, graded and ungraded, excluding USDA Prime and Choice, per lb. (453.6 gm)"))
                .add(new AreaItemCode("703213", "Chuck roast, USDA Choice, boneless, per lb. (453.6 gm)"))
                .add(new AreaItemCode("703311", "Round roast, USDA Choice, boneless, per lb. (453.6 gm)"))
                .add(new AreaItemCode("703312", "Round roast, graded and ungraded, excluding USDA Prime and Choice, per lb. (453.6 gm)"))
                .add(new AreaItemCode("703411", "Rib roast, USDA Choice, bone-in, per lb. (453.6 gm)"))
                .add(new AreaItemCode("703421", "Steak, chuck, U.S. choice, bone-in (cost per pound/453.6 grams)"))
                .add(new AreaItemCode("703422", "Steak, T-Bone, USDA Choice, bone-in, per lb. (453.6 gm)"))
                .add(new AreaItemCode("703423", "Steak, porterhouse, U.S. choice, bone-in (cost per pound/453.6 grams)"))
                .add(new AreaItemCode("703425", "Steak, rib eye, USDA Choice, boneless, per lb. (453.6 gm)"))
                .add(new AreaItemCode("703431", "Short ribs, any primal source, bone-in, per lb. (453.6 gm)"))
                .add(new AreaItemCode("703432", "Beef for stew, boneless, per lb. (453.6 gm)"))
                .add(new AreaItemCode("703511", "Steak, round, USDA Choice, boneless, per lb. (453.6 gm)"))
                .add(new AreaItemCode("703512", "Steak, round, graded and ungraded, excluding USDA Prime and Choice, per lb. (453.6 gm)"))
                .add(new AreaItemCode("703611", "Steak, sirloin, USDA Choice, bone-in, per lb. (453.6 gm)"))
                .add(new AreaItemCode("703612", "Steak, sirloin, graded and ungraded, excluding USDA Prime and Choice, per lb. (453.6 gm)"))
                .add(new AreaItemCode("703613", "Steak, sirloin, USDA Choice, boneless, per lb. (453.6 gm)"))
                .add(new AreaItemCode("704111", "Bacon, sliced, per lb. (453.6 gm)"))
                .add(new AreaItemCode("704211", "Chops, center cut, bone-in, per lb. (453.6 gm)"))
                .add(new AreaItemCode("704212", "Chops, boneless, per lb. (453.6 gm)"))
                .add(new AreaItemCode("704311", "Ham, rump or shank half, bone-in, smoked,per lb. (453.6 gm)"))
                .add(new AreaItemCode("704312", "Ham, boneless, excluding canned, per lb. (453.6 gm)"))
                .add(new AreaItemCode("704313", "Ham, rump portion, bone-in, smoked (cost per pound/453.6 grams)"))
                .add(new AreaItemCode("704314", "Ham, shank portion, bone-in, smoked (cost per pound/453.6 grams)"))
                .add(new AreaItemCode("704321", "Ham, canned, 3 or 5 lbs, per lb. (453.6 gm)"))
                .add(new AreaItemCode("704411", "Pork shoulder roast, blade boston, bone-in (cost per pound/453.6 grams)"))
                .add(new AreaItemCode("704412", "Pork sirloin roast, bone-in (cost per pound/453.6 grams)"))
                .add(new AreaItemCode("704413", "Shoulder picnic, bone-in, smoked, per lb. (453.6 gm)"))
                .add(new AreaItemCode("704421", "Sausage, fresh, loose, per lb. (453.6 gm)"))
                .add(new AreaItemCode("705111", "Frankfurters, all meat or all beef, per lb. (453.6 gm)"))
                .add(new AreaItemCode("705121", "Bologna, all beef or mixed, per lb. (453.6 gm)"))
                .add(new AreaItemCode("705141", "Beef liver (cost per pound/453.6 grams)"))
                .add(new AreaItemCode("705142", "Lamb and mutton, bone-in, per lb. (453.6 gm)"))
                .add(new AreaItemCode("706111", "Chicken, fresh, whole, per lb. (453.6 gm)"))
                .add(new AreaItemCode("706211", "Chicken breast, bone-in, per lb. (453.6 gm)"))
                .add(new AreaItemCode("706212", "Chicken legs, bone-in, per lb. (453.6 gm)"))
                .add(new AreaItemCode("706311", "Turkey, frozen, whole, per lb. (453.6 gm)"))
                .add(new AreaItemCode("707111", "Tuna, light, chunk, per lb. (453.6 gm)"))
                .add(new AreaItemCode("708111", "Eggs, grade A, large, per doz."))
                .add(new AreaItemCode("708112", "Eggs, grade AA, large, per doz."))
                .add(new AreaItemCode("709111", "Milk, fresh, whole, fortified, per 1/2 gal. (1.9 lit)"))
                .add(new AreaItemCode("709112", "Milk, fresh, whole, fortified, per gal. (3.8 lit)"))
                .add(new AreaItemCode("709211", "Milk, fresh, skim (cost per one-half gallon/1.9 liters)"))
                .add(new AreaItemCode("709212", "Milk, fresh, low fat, per 1/2 gal. (1.9 lit)"))
                .add(new AreaItemCode("709213", "Milk, fresh, low fat, per gal. (3.8 lit)"))
                .add(new AreaItemCode("710111", "Butter, salted, grade AA, stick, per lb. (453.6 gm)"))
                .add(new AreaItemCode("710122", "Yogurt, natural, fruit flavored, per 8 oz. (226.8 gm)"))
                .add(new AreaItemCode("710211", "American processed cheese, per lb. (453.6 gm)"))
                .add(new AreaItemCode("710212", "Cheddar cheese, natural, per lb. (453.6 gm)"))
                .add(new AreaItemCode("710411", "Ice cream, prepackaged, bulk, regular, per 1/2 gal. (1.9 lit)"))
                .add(new AreaItemCode("711111", "Apples, Red Delicious, per lb. (453.6 gm)"))
                .add(new AreaItemCode("711211", "Bananas, per lb. (453.6 gm)"))
                .add(new AreaItemCode("711311", "Oranges, Navel, per lb. (453.6 gm)"))
                .add(new AreaItemCode("711312", "Oranges, Valencia, per lb. (453.6 gm)"))
                .add(new AreaItemCode("711411", "Grapefruit, per lb. (453.6 gm)"))
                .add(new AreaItemCode("711412", "Lemons, per lb. (453.6 gm)"))
                .add(new AreaItemCode("711413", "Pears, Anjou, per lb. (453.6 gm)"))
                .add(new AreaItemCode("711414", "Peaches, per lb. (453.6 gm)"))
                .add(new AreaItemCode("711415", "Strawberries, dry pint, per 12 oz. (340.2 gm)"))
                .add(new AreaItemCode("711416", "Grapes, Emperor or Tokay (cost per pound/453.6 grams)"))
                .add(new AreaItemCode("711417", "Grapes, Thompson Seedless, per lb. (453.6 gm)"))
                .add(new AreaItemCode("711418", "Cherries, per lb. (453.6 gm)"))
                .add(new AreaItemCode("712111", "Potatoes, white (cost per pound/453.6 grams)"))
                .add(new AreaItemCode("712112", "Potatoes, white, per lb. (453.6 gm)"))
                .add(new AreaItemCode("712211", "Lettuce, iceberg, per lb. (453.6 gm)"))
                .add(new AreaItemCode("712311", "Tomatoes, field grown, per lb. (453.6 gm)"))
                .add(new AreaItemCode("712401", "Cabbage, per lb. (453.6 gm)"))
                .add(new AreaItemCode("712402", "Celery, per lb. (453.6 gm)"))
                .add(new AreaItemCode("712403", "Carrots, short trimmed and topped, per lb. (453.6 gm)"))
                .add(new AreaItemCode("712404", "Onions, dry yellow, per lb. (453.6 gm)"))
                .add(new AreaItemCode("712405", "Onions, green scallions (cost per pound/453.6 grams)"))
                .add(new AreaItemCode("712406", "Peppers, sweet, per lb. (453.6 gm)"))
                .add(new AreaItemCode("712407", "Corn on the cob, per lb. (453.6 gm)"))
                .add(new AreaItemCode("712408", "Radishes (cost per pound/453.6 grams)"))
                .add(new AreaItemCode("712409", "Cucumbers, per lb. (453.6 gm)"))
                .add(new AreaItemCode("712410", "Beans, green, snap (cost per pound/453.6 grams)"))
                .add(new AreaItemCode("712411", "Mushrooms (cost per pound/453.6 grams)"))
                .add(new AreaItemCode("712412", "Broccoli, per lb. (453.6 gm)"))
                .add(new AreaItemCode("713111", "Orange juice, frozen concentrate, 12 oz. can, per 16 oz. (473.2 ml)"))
                .add(new AreaItemCode("713311", "Apple Sauce, any variety, all sizes, per lb. (453.6 gm)"))
                .add(new AreaItemCode("713312", "Peaches, any variety, all sizes, per lb. (453.6 gm)"))
                .add(new AreaItemCode("714111", "Potatoes, frozen, French fried, per lb. (453.6 gm)"))
                .add(new AreaItemCode("714221", "Corn, canned, any style, all sizes, per lb. (453.6 gm)"))
                .add(new AreaItemCode("714231", "Tomatoes, canned, whole, per lb. (453.6 gm)"))
                .add(new AreaItemCode("714232", "Tomatoes, canned, any type, all sizes,  per lb. (453.6 gm)"))
                .add(new AreaItemCode("714233", "Beans, dried, any type, all sizes, per lb. (453.6 gm)"))
                .add(new AreaItemCode("715111", "Hard candy, solid (cost per pound/453.6 grams)"))
                .add(new AreaItemCode("715211", "Sugar, white, all sizes, per lb. (453.6 gm)"))
                .add(new AreaItemCode("715212", "Sugar, white, 33-80 oz. pkg, per lb. (453.6 gm)"))
                .add(new AreaItemCode("715311", "Jelly (cost per pound/453.6 grams)"))
                .add(new AreaItemCode("716111", "Margarine, vegetable oil blends, stick (cost per pound/453.6 grams)"))
                .add(new AreaItemCode("716113", "Margarine, vegetable oil blends, soft, tubs (cost per pound/453.6 grams)"))
                .add(new AreaItemCode("716114", "Margarine, stick, per lb. (453.6 gm)"))
                .add(new AreaItemCode("716116", "Margarine, soft, tubs, per lb. (453.6 gm)"))
                .add(new AreaItemCode("716121", "Shortening, vegetable oil blends, per lb. (453.6 gm)"))
                .add(new AreaItemCode("716141", "Peanut butter, creamy, all sizes, per lb. (453.6 gm)"))
                .add(new AreaItemCode("717111", "Cola, non-diet, return bottles, 6 or 8 pack (cost per 16 ounces/473.2 ml)"))
                .add(new AreaItemCode("717112", "Cola, non diet, return bottles, 24-40 ounce (cost per 16 ounces/473.2 ml)"))
                .add(new AreaItemCode("717113", "Cola, nondiet, cans, 72 oz. 6 pk., per 16 oz. (473.2 ml)"))
                .add(new AreaItemCode("717114", "Cola, nondiet, per 2 liters (67.6 oz)"))
                .add(new AreaItemCode("717311", "Coffee, 100%, ground roast, all sizes, per lb. (453.6 gm)"))
                .add(new AreaItemCode("717312", "Coffee, 100%, ground roast, 13.1-20 oz. can, per lb. (453.6 gm)"))
                .add(new AreaItemCode("717324", "Coffee, instant, plain, regular, 6.1-14 ounce (cost per 16 ounces/453.6 grams)"))
                .add(new AreaItemCode("717325", "Coffee, freeze dried, regular, all sizes (cost per 16 ounces/453.6 grams)"))
                .add(new AreaItemCode("717326", "Coffee, freeze dried, decaf., all sizes (cost per 16 ounces/453.6 grams)"))
                .add(new AreaItemCode("717327", "Coffee, instant, plain, regular, all sizes, per lb. (453.6 gm)"))
                .add(new AreaItemCode("717411", "Coffee, instant, plain, 9.1-14 ounce (cost per 16 ounces/453.6 grams)"))
                .add(new AreaItemCode("717412", "Coffee, instant, plain, 3.1-6 ounce (cost per 16 ounces/453.6 grams)"))
                .add(new AreaItemCode("717413", "Coffee, freeze dried, plain, 3.1-9 ounce (cost per 16 ounces/453.6 grams)"))
                .add(new AreaItemCode("718311", "Potato chips, per 16 oz."))
                .add(new AreaItemCode("718631", "Pork and beans, canned (cost per 16 ounces/453.6 grams)"))
                .add(new AreaItemCode("720111", "Malt beverages, all types, all sizes, any origin, per 16 oz. (473.2 ml)"))
                .add(new AreaItemCode("720211", "Bourbon whiskey, 375 ml-1.75 liter (cost per 25.4 ounces/750 ml)"))
                .add(new AreaItemCode("720221", "Vodka, domestic, 375 ml-1.75 liter (cost per 25.4 ounces/750 ml)"))
                .add(new AreaItemCode("720222", "Vodka, all types, all sizes, any origin, per 1 liter (33.8 oz)"))
                .add(new AreaItemCode("720311", "Wine, red and white table, all sizes, any origin, per 1 liter (33.8 oz)"))
                .add(new AreaItemCode("72511", "Fuel oil #2 per gallon (3.785 liters)"))
                .add(new AreaItemCode("72601", "Utility (piped) gas - 40 therms"))
                .add(new AreaItemCode("72610", "Electricity per KWH"))
                .add(new AreaItemCode("72611", "Utility (piped) gas - 100 therms"))
                .add(new AreaItemCode("72620", "Utility (piped) gas per therm"))
                .add(new AreaItemCode("72621", "Electricity per 500 KWH"))
                .add(new AreaItemCode("74712", "Gasoline, leaded regular (cost per gallon/3.8 liters)"))
                .add(new AreaItemCode("74713", "Gasoline, leaded premium (cost per gallon/3.8 liters)"))
                .add(new AreaItemCode("74714", "Gasoline, unleaded regular, per gallon/3.785 liters"))
                .add(new AreaItemCode("74715", "Gasoline, unleaded midgrade, per gallon/3.785 liters"))
                .add(new AreaItemCode("74716", "Gasoline, unleaded premium, per gallon/3.785 liters"))
                .add(new AreaItemCode("74717", "Automotive diesel fuel, per gallon/3.785 liters"))
                .add(new AreaItemCode("7471A", "Gasoline, all types, per gallon/3.785 liters"))
                .add(new AreaItemCode("FC1101", "All uncooked ground beef, per lb. (453.6 gm)"))
                .add(new AreaItemCode("FC2101", "All Uncooked Beef Roasts, per lb. (453.6 gm)"))
                .add(new AreaItemCode("FC3101", "All Uncooked Beef Steaks, per lb. (453.6 gm)"))
                .add(new AreaItemCode("FC4101", "All Uncooked Other Beef (Excluding Veal), per lb. (453.6 gm)"))
                .add(new AreaItemCode("FD2101", "All Ham (Excluding Canned Ham and Luncheon Slices), per lb. (453.6 gm)"))
                .add(new AreaItemCode("FD3101", "All Pork Chops, per lb. (453.6 gm)"))
                .add(new AreaItemCode("FD4101", "All Other Pork (Excluding Canned Ham and Luncheon Slices), per lb. (453.6 gm)"))
                .add(new AreaItemCode("FF1101", "Chicken breast, boneless, per lb. (453.6 gm)"))
                .add(new AreaItemCode("FL2101", "Lettuce, romaine, per lb. (453.6 gm)"))
                .build();
    }

    public List<AreaItemCode> getAreaCodes(BlsRequestType requestType) {
        switch (requestType) {
            case AVERAGE_PRICE:
                return AREA_CODES_AVERAGE_PRICE;
            default:
                throw new IllegalArgumentException("RequestType unsupported for getAreaCodes request.");
        }
    }

    public List<AreaItemCode> getItemCodes(BlsRequestType requestType) {
        switch (requestType) {
            case AVERAGE_PRICE:
                return ITEM_CODES_AVERAGE_PRICE;
            default:
                throw new IllegalArgumentException("RequestType unsupported for getItemCodes request.");
        }
    }

}
