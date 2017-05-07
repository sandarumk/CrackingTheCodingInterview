/**
 * What to do: First line contains a set of keywords. Second line contains teh number of reviews. Then each line contains the hotel ID and respective review.
 *
 * Output: how many times the items in the keywords set is mentioned in teh reviews.
 * Sort the hotel IDs in Decending order.
 *
 * Input:
 breakfast beach citycenter location metro view staff price
 5
 1
 This hotel has a nice view of the citycenter. The location is perfect.
 2
 The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.
 1
 Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.
 1
 They said I couldn't take my dog and there were other guests with dogs! That is not fair.
 2
 Very friendly staff and good cost-benefit ratio. Location is a bit far from citycenter.
 2
 1
 */



import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner (System.in);
        String wordList = sc.nextLine();
        String[] keywords = wordList.split(" ");
        int noReviews = sc.nextInt();
        int lineNo = 0;
        Map<Integer,Integer> reviewScoreHotelMap = new HashMap<Integer,Integer>();
        while (lineNo < (noReviews*2)-1){
            int hotelID = sc.nextInt();
            lineNo++;
            String review = sc.nextLine();
            review = sc.nextLine();
            lineNo++;
            int reviewScore = countKeywords(review,keywords);
            if(reviewScoreHotelMap.containsKey(hotelID)){
                reviewScore = reviewScoreHotelMap.get(hotelID)+reviewScore;
                reviewScoreHotelMap.put(hotelID,reviewScore);
            }else{
                reviewScoreHotelMap.put(hotelID,reviewScore);
            }
        }

        Object[] a = reviewScoreHotelMap.entrySet().toArray();
        Arrays.sort(a,new Comparator(){
            public int compare (Object o1, Object o2){
                return ((Map.Entry<Integer,Integer>) o2).getValue().compareTo(((Map.Entry<Integer,Integer>)o1).getValue());
            }
        });

        for(Object e:a){
            System.out.println(((Map.Entry<Integer,Integer>)e).getKey());
        }


    }

    private static int countKeywords(String review, String[] keywordList){
        int noKeyWords = 0;
        for(String keyword:keywordList ){
            noKeyWords += countMatches(review,keyword);
        }
        return noKeyWords;
    }

    private static int countMatches(String review, String keyWord){
        Pattern pattern = Pattern.compile(keyWord);
        Matcher matcher = pattern.matcher(review);
        int count = 0;
        int pos = 0;
        while(matcher.find(pos)){
            count++;
            pos = matcher.start()+1;
        }
        return count;
    }
}