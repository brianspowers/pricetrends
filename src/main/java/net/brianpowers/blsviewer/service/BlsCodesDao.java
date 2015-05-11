package net.brianpowers.blsviewer.service;

import com.google.common.collect.ImmutableMap;
import net.brianpowers.blsviewer.api.BlsRequestType;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Service to retrieve lists of valid codes for making requests to the BLS Data services.  Codelists are hard-coded for
 * now, but this should probably go to an external data-store as we support more requests.
 */
@Service
public class BlsCodesDao {

    private final ImmutableMap<String, String> AREA_CODES_AVERAGE_PRICE;
    private final ImmutableMap<String, String> ITEM_CODES_AVERAGE_PRICE;

    public BlsCodesDao() {
        AREA_CODES_AVERAGE_PRICE = ImmutableMap.<String, String>builder()
                .put("0000", "U.S. city average")
                .put("0100", "Northeast urban")
                .put("0200", "Midwest urban")
                .put("0300", "South urban")
                .put("0400", "West urban")
                .put("A000", "City size A")
                .put("A100", "Northeast Size A")
                .put("A101", "New York-Northern New Jersey-Long Island, NY-NJ-CT-PA")
                .put("A102", "Philadelphia-Wilmington-Atlantic City, PA-NJ-DE-MD")
                .put("A103", "Boston-Brockton-Nashua, MA-NH-ME-CT")
                .put("A104", "Pittsburgh, PA")
                .put("A105", "Buffalo-Niagara Falls, NY")
                .put("A106", "Scranton, PA")
                .put("A200", "Midwest Size A")
                .put("A207", "Chicago-Gary-Kenosha, IL-IN-WI")
                .put("A208", "Detroit-Ann Arbor-Flint, MI")
                .put("A209", "St. Louis, MO-IL")
                .put("A210", "Cleveland-Akron, OH")
                .put("A211", "Minneapolis-St. Paul, MN-WI")
                .put("A212", "Milwaukee-Racine, WI")
                .put("A213", "Cincinnati-Hamilton, OH-KY-IN")
                .put("A214", "Kansas City, MO-KS")
                .put("A300", "South Size A")
                .put("A311", "Washington-Baltimore, DC-MD-VA-WV")
                .put("A315", "Washington, DC-MD-VA")
                .put("A316", "Dallas-Fort Worth, TX")
                .put("A317", "Baltimore, MD")
                .put("A318", "Houston-Galveston-Brazoria, TX")
                .put("A319", "Atlanta, GA")
                .put("A320", "Miami-Fort Lauderdale, FL")
                .put("A400", "West Size A")
                .put("A421", "Los Angeles-Riverside-Orange County, CA")
                .put("A422", "San Francisco-Oakland-San Jose, CA")
                .put("A423", "Seattle-Tacoma-Bremerton, WA")
                .put("A424", "San Diego, CA")
                .put("A425", "Portland-Salem, OR-WA")
                .put("A426", "Honolulu, HI")
                .put("A427", "Anchorage, AK")
                .put("A433", "Denver-Boulder-Greeley, CO")
                .put("B000", "City size B")
                .put("B100", "Northeast size B")
                .put("B200", "North Central size B")
                .put("B300", "South size B")
                .put("B400", "West size B")
                .put("C000", "City size C")
                .put("C100", "Northeast size C")
                .put("C200", "North Central size C")
                .put("C300", "South size C")
                .put("C400", "West size C")
                .put("D000", "City size D")
                .put("D100", "Northeast size D")
                .put("D200", "Midwest Size D")
                .put("D300", "South Size D")
                .put("D400", "West size D")
                .put("X000", "City size B/C")
                .put("X100", "Northeast Size B/C")
                .put("X200", "Midwest Size B/C")
                .put("X300", "South Size B/C")
                .put("X400", "West Size B/C")
                .build();
        ITEM_CODES_AVERAGE_PRICE = ImmutableMap.<String, String>builder()
                .put("701111", "Flour, white, all purpose, per lb. (453.6 gm)")
                .put("701311", "Rice, white, long grain, precooked (cost per pound/453.6 grams)")
                .put("701312", "Rice, white, long grain, uncooked, per lb. (453.6 gm)")
                .put("701321", "Spaghetti (cost per pound/453.6 grams)")
                .put("701322", "Spaghetti and macaroni, per lb. (453.6 gm)")
                .put("702111", "Bread, white, pan, per lb. (453.6 gm)")
                .put("702112", "Bread, French, per lb. (453.6 gm)")
                .put("702211", "Bread, rye, pan (cost per pound/453.6 grams)")
                .put("702212", "Bread, whole wheat, pan, per lb. (453.6 gm)")
                .put("702213", "Bread, wheat blend, pan (cost per pound/453.6 grams)")
                .put("702221", "Rolls, hamburger (cost per pound/453.6 grams)")
                .put("702411", "Cupcakes, chocolate (cost per pound/453.6 grams)")
                .put("702421", "Cookies, chocolate chip, per lb. (453.6 gm)")
                .put("702611", "Crackers, soda, salted, per lb. (453.6 gm)")
                .put("703111", "Ground chuck, 100% beef, per lb. (453.6 gm)")
                .put("703112", "Ground beef, 100% beef, per lb. (453.6 gm)")
                .put("703113", "Ground beef, lean and extra lean, per lb. (453.6 gm)")
                .put("703211", "Chuck roast, USDA Choice, bone-in, per lb. (453.6 gm)")
                .put("703212", "Chuck roast, graded and ungraded, excluding USDA Prime and Choice, per lb. (453.6 gm)")
                .put("703213", "Chuck roast, USDA Choice, boneless, per lb. (453.6 gm)")
                .put("703311", "Round roast, USDA Choice, boneless, per lb. (453.6 gm)")
                .put("703312", "Round roast, graded and ungraded, excluding USDA Prime and Choice, per lb. (453.6 gm)")
                .put("703411", "Rib roast, USDA Choice, bone-in, per lb. (453.6 gm)")
                .put("703421", "Steak, chuck, U.S. choice, bone-in (cost per pound/453.6 grams)")
                .put("703422", "Steak, T-Bone, USDA Choice, bone-in, per lb. (453.6 gm)")
                .put("703423", "Steak, porterhouse, U.S. choice, bone-in (cost per pound/453.6 grams)")
                .put("703425", "Steak, rib eye, USDA Choice, boneless, per lb. (453.6 gm)")
                .put("703431", "Short ribs, any primal source, bone-in, per lb. (453.6 gm)")
                .put("703432", "Beef for stew, boneless, per lb. (453.6 gm)")
                .put("703511", "Steak, round, USDA Choice, boneless, per lb. (453.6 gm)")
                .put("703512", "Steak, round, graded and ungraded, excluding USDA Prime and Choice, per lb. (453.6 gm)")
                .put("703611", "Steak, sirloin, USDA Choice, bone-in, per lb. (453.6 gm)")
                .put("703612", "Steak, sirloin, graded and ungraded, excluding USDA Prime and Choice, per lb. (453.6 gm)")
                .put("703613", "Steak, sirloin, USDA Choice, boneless, per lb. (453.6 gm)")
                .put("704111", "Bacon, sliced, per lb. (453.6 gm)")
                .put("704211", "Chops, center cut, bone-in, per lb. (453.6 gm)")
                .put("704212", "Chops, boneless, per lb. (453.6 gm)")
                .put("704311", "Ham, rump or shank half, bone-in, smoked,per lb. (453.6 gm)")
                .put("704312", "Ham, boneless, excluding canned, per lb. (453.6 gm)")
                .put("704313", "Ham, rump portion, bone-in, smoked (cost per pound/453.6 grams)")
                .put("704314", "Ham, shank portion, bone-in, smoked (cost per pound/453.6 grams)")
                .put("704321", "Ham, canned, 3 or 5 lbs, per lb. (453.6 gm)")
                .put("704411", "Pork shoulder roast, blade boston, bone-in (cost per pound/453.6 grams)")
                .put("704412", "Pork sirloin roast, bone-in (cost per pound/453.6 grams)")
                .put("704413", "Shoulder picnic, bone-in, smoked, per lb. (453.6 gm)")
                .put("704421", "Sausage, fresh, loose, per lb. (453.6 gm)")
                .put("705111", "Frankfurters, all meat or all beef, per lb. (453.6 gm)")
                .put("705121", "Bologna, all beef or mixed, per lb. (453.6 gm)")
                .put("705141", "Beef liver (cost per pound/453.6 grams)")
                .put("705142", "Lamb and mutton, bone-in, per lb. (453.6 gm)")
                .put("706111", "Chicken, fresh, whole, per lb. (453.6 gm)")
                .put("706211", "Chicken breast, bone-in, per lb. (453.6 gm)")
                .put("706212", "Chicken legs, bone-in, per lb. (453.6 gm)")
                .put("706311", "Turkey, frozen, whole, per lb. (453.6 gm)")
                .put("707111", "Tuna, light, chunk, per lb. (453.6 gm)")
                .put("708111", "Eggs, grade A, large, per doz.")
                .put("708112", "Eggs, grade AA, large, per doz.")
                .put("709111", "Milk, fresh, whole, fortified, per 1/2 gal. (1.9 lit)")
                .put("709112", "Milk, fresh, whole, fortified, per gal. (3.8 lit)")
                .put("709211", "Milk, fresh, skim (cost per one-half gallon/1.9 liters)")
                .put("709212", "Milk, fresh, low fat, per 1/2 gal. (1.9 lit)")
                .put("709213", "Milk, fresh, low fat, per gal. (3.8 lit)")
                .put("710111", "Butter, salted, grade AA, stick, per lb. (453.6 gm)")
                .put("710122", "Yogurt, natural, fruit flavored, per 8 oz. (226.8 gm)")
                .put("710211", "American processed cheese, per lb. (453.6 gm)")
                .put("710212", "Cheddar cheese, natural, per lb. (453.6 gm)")
                .put("710411", "Ice cream, prepackaged, bulk, regular, per 1/2 gal. (1.9 lit)")
                .put("711111", "Apples, Red Delicious, per lb. (453.6 gm)")
                .put("711211", "Bananas, per lb. (453.6 gm)")
                .put("711311", "Oranges, Navel, per lb. (453.6 gm)")
                .put("711312", "Oranges, Valencia, per lb. (453.6 gm)")
                .put("711411", "Grapefruit, per lb. (453.6 gm)")
                .put("711412", "Lemons, per lb. (453.6 gm)")
                .put("711413", "Pears, Anjou, per lb. (453.6 gm)")
                .put("711414", "Peaches, per lb. (453.6 gm)")
                .put("711415", "Strawberries, dry pint, per 12 oz. (340.2 gm)")
                .put("711416", "Grapes, Emperor or Tokay (cost per pound/453.6 grams)")
                .put("711417", "Grapes, Thompson Seedless, per lb. (453.6 gm)")
                .put("711418", "Cherries, per lb. (453.6 gm)")
                .put("712111", "Potatoes, white (cost per pound/453.6 grams)")
                .put("712112", "Potatoes, white, per lb. (453.6 gm)")
                .put("712211", "Lettuce, iceberg, per lb. (453.6 gm)")
                .put("712311", "Tomatoes, field grown, per lb. (453.6 gm)")
                .put("712401", "Cabbage, per lb. (453.6 gm)")
                .put("712402", "Celery, per lb. (453.6 gm)")
                .put("712403", "Carrots, short trimmed and topped, per lb. (453.6 gm)")
                .put("712404", "Onions, dry yellow, per lb. (453.6 gm)")
                .put("712405", "Onions, green scallions (cost per pound/453.6 grams)")
                .put("712406", "Peppers, sweet, per lb. (453.6 gm)")
                .put("712407", "Corn on the cob, per lb. (453.6 gm)")
                .put("712408", "Radishes (cost per pound/453.6 grams)")
                .put("712409", "Cucumbers, per lb. (453.6 gm)")
                .put("712410", "Beans, green, snap (cost per pound/453.6 grams)")
                .put("712411", "Mushrooms (cost per pound/453.6 grams)")
                .put("712412", "Broccoli, per lb. (453.6 gm)")
                .put("713111", "Orange juice, frozen concentrate, 12 oz. can, per 16 oz. (473.2 ml)")
                .put("713311", "Apple Sauce, any variety, all sizes, per lb. (453.6 gm)")
                .put("713312", "Peaches, any variety, all sizes, per lb. (453.6 gm)")
                .put("714111", "Potatoes, frozen, French fried, per lb. (453.6 gm)")
                .put("714221", "Corn, canned, any style, all sizes, per lb. (453.6 gm)")
                .put("714231", "Tomatoes, canned, whole, per lb. (453.6 gm)")
                .put("714232", "Tomatoes, canned, any type, all sizes,  per lb. (453.6 gm)")
                .put("714233", "Beans, dried, any type, all sizes, per lb. (453.6 gm)")
                .put("715111", "Hard candy, solid (cost per pound/453.6 grams)")
                .put("715211", "Sugar, white, all sizes, per lb. (453.6 gm)")
                .put("715212", "Sugar, white, 33-80 oz. pkg, per lb. (453.6 gm)")
                .put("715311", "Jelly (cost per pound/453.6 grams)")
                .put("716111", "Margarine, vegetable oil blends, stick (cost per pound/453.6 grams)")
                .put("716113", "Margarine, vegetable oil blends, soft, tubs (cost per pound/453.6 grams)")
                .put("716114", "Margarine, stick, per lb. (453.6 gm)")
                .put("716116", "Margarine, soft, tubs, per lb. (453.6 gm)")
                .put("716121", "Shortening, vegetable oil blends, per lb. (453.6 gm)")
                .put("716141", "Peanut butter, creamy, all sizes, per lb. (453.6 gm)")
                .put("717111", "Cola, non-diet, return bottles, 6 or 8 pack (cost per 16 ounces/473.2 ml)")
                .put("717112", "Cola, non diet, return bottles, 24-40 ounce (cost per 16 ounces/473.2 ml)")
                .put("717113", "Cola, nondiet, cans, 72 oz. 6 pk., per 16 oz. (473.2 ml)")
                .put("717114", "Cola, nondiet, per 2 liters (67.6 oz)")
                .put("717311", "Coffee, 100%, ground roast, all sizes, per lb. (453.6 gm)")
                .put("717312", "Coffee, 100%, ground roast, 13.1-20 oz. can, per lb. (453.6 gm)")
                .put("717324", "Coffee, instant, plain, regular, 6.1-14 ounce (cost per 16 ounces/453.6 grams)")
                .put("717325", "Coffee, freeze dried, regular, all sizes (cost per 16 ounces/453.6 grams)")
                .put("717326", "Coffee, freeze dried, decaf., all sizes (cost per 16 ounces/453.6 grams)")
                .put("717327", "Coffee, instant, plain, regular, all sizes, per lb. (453.6 gm)")
                .put("717411", "Coffee, instant, plain, 9.1-14 ounce (cost per 16 ounces/453.6 grams)")
                .put("717412", "Coffee, instant, plain, 3.1-6 ounce (cost per 16 ounces/453.6 grams)")
                .put("717413", "Coffee, freeze dried, plain, 3.1-9 ounce (cost per 16 ounces/453.6 grams)")
                .put("718311", "Potato chips, per 16 oz.")
                .put("718631", "Pork and beans, canned (cost per 16 ounces/453.6 grams)")
                .put("720111", "Malt beverages, all types, all sizes, any origin, per 16 oz. (473.2 ml)")
                .put("720211", "Bourbon whiskey, 375 ml-1.75 liter (cost per 25.4 ounces/750 ml)")
                .put("720221", "Vodka, domestic, 375 ml-1.75 liter (cost per 25.4 ounces/750 ml)")
                .put("720222", "Vodka, all types, all sizes, any origin, per 1 liter (33.8 oz)")
                .put("720311", "Wine, red and white table, all sizes, any origin, per 1 liter (33.8 oz)")
                .put("72511", "Fuel oil #2 per gallon (3.785 liters)")
                .put("72601", "Utility (piped) gas - 40 therms")
                .put("72610", "Electricity per KWH")
                .put("72611", "Utility (piped) gas - 100 therms")
                .put("72620", "Utility (piped) gas per therm")
                .put("72621", "Electricity per 500 KWH")
                .put("74712", "Gasoline, leaded regular (cost per gallon/3.8 liters)")
                .put("74713", "Gasoline, leaded premium (cost per gallon/3.8 liters)")
                .put("74714", "Gasoline, unleaded regular, per gallon/3.785 liters")
                .put("74715", "Gasoline, unleaded midgrade, per gallon/3.785 liters")
                .put("74716", "Gasoline, unleaded premium, per gallon/3.785 liters")
                .put("74717", "Automotive diesel fuel, per gallon/3.785 liters")
                .put("7471A", "Gasoline, all types, per gallon/3.785 liters")
                .put("FC1101", "All uncooked ground beef, per lb. (453.6 gm)")
                .put("FC2101", "All Uncooked Beef Roasts, per lb. (453.6 gm)")
                .put("FC3101", "All Uncooked Beef Steaks, per lb. (453.6 gm)")
                .put("FC4101", "All Uncooked Other Beef (Excluding Veal), per lb. (453.6 gm)")
                .put("FD2101", "All Ham (Excluding Canned Ham and Luncheon Slices), per lb. (453.6 gm)")
                .put("FD3101", "All Pork Chops, per lb. (453.6 gm)")
                .put("FD4101", "All Other Pork (Excluding Canned Ham and Luncheon Slices), per lb. (453.6 gm)")
                .put("FF1101", "Chicken breast, boneless, per lb. (453.6 gm)")
                .put("FL2101", "Lettuce, romaine, per lb. (453.6 gm)")
                .build();
    }

    public Map<String, String> getAreaCodes(BlsRequestType requestType) {
        switch (requestType) {
            case AVERAGE_PRICE:
                return AREA_CODES_AVERAGE_PRICE;
            default:
                throw new IllegalArgumentException("RequestType unsupported for getAreaCodes request.");
        }
    }

    public Map<String, String> getItemCodes(BlsRequestType requestType) {
        switch (requestType) {
            case AVERAGE_PRICE:
                return ITEM_CODES_AVERAGE_PRICE;
            default:
                throw new IllegalArgumentException("RequestType unsupported for getItemCodes request.");
        }
    }

}
