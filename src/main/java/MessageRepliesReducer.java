

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * Created by ubuntu on 2/6/17.
 */
public class MessageRepliesReducer extends Reducer<Text, Text, Text, Text> {

   
    protected void reduce(Text key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {
       
        
        int count = 0;
        String r = "";
        
        
        for (Text value : values ){
            count++;
            r = value.toString() + "|";
 
        }
       
        context.write(key, new Text(r));
    }
}