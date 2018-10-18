

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
public class ScreenameMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
    	
	 	JsonNode twitter_data = new ObjectMapper().readTree(value.toString());
        String screen_name = twitter_data.get("user").get("name").textValue();
        context.write(new Text(screen_name), new IntWritable(1));
        
        	 

    }
}
