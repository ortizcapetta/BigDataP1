

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by ubuntu on 2/6/17.
 */
public class MessageRepliesMapper extends Mapper<LongWritable, Text, Text, Text> {

   
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
    	
	 	JsonNode twitter_data = new ObjectMapper().readTree(value.toString());
	 	
	 	
        String original_tweet = twitter_data.get("in_reply_to_status_id_str").textValue();
        String tweet = twitter_data.get("id_str").textValue();
        //String[] words = full_text.split(" ");
        if(original_tweet != null) {
       
        	context.write(new Text(original_tweet), new Text(tweet));
        }
       
} 
    }
