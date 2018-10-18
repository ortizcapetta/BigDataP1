

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ubuntu on 2/6/17.
 */
public class SpecificWordMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
    	
	 	JsonNode twitter_data = new ObjectMapper().readTree(value.toString());
        
        String full_text = twitter_data.get("extended_tweet").get("full_text").textValue();
        String[] words = full_text.split(" ");
        
        Set<String> keywords = new HashSet<String>(Arrays.asList("trump","flu","zika","ebola","diarrhea","headache","measles"));
        for (String word: words) {
        		if(keywords.contains(word.toLowerCase())) {
        			 context.write(new Text(word.toLowerCase()), new IntWritable(1));
        		}
        	 
} 
    }
}
