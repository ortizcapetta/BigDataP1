

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;

/**
 * Created by ubuntu on 2/6/17.
 */
public class MessageByUserMapper extends Mapper<LongWritable, Text, Text, Text> {

   
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
    	
	 	JsonNode twitter_data = new ObjectMapper().readTree(value.toString());
	 	
	 	
        String uid = twitter_data.get("user").get("id_str").textValue();
        String message = twitter_data.get("text").textValue().trim();
        context.write(new Text(uid), new Text(message.trim().replaceAll("\\s+"," ")));
        	
        	
    }
}
