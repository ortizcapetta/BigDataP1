

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * Created by ubuntu on 2/6/17.
 */
public class CountSpecificWordOcurrences{
    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.err.println("Usage: <MR_{NUMBER}> <input path> <output path>");
            System.exit(-1);
        }
        
        Job job = new Job();
        job.setJarByClass(CountSpecificWordOcurrences.class);
        job.setJobName("Count Words");
       
        FileInputFormat.addInputPath(job, new Path(args[1]));
        FileOutputFormat.setOutputPath(job, new Path(args[2]));
        //Ex1
        if(args[0].toString().equals("mr1")) {
        	job.setMapperClass(SpecificWordMapper.class);
        	job.setReducerClass(SpecificWordReducer.class);
        	job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(IntWritable.class);
        }else if(args[0].toString().toLowerCase().equals("mr2")) {
        	job.setMapperClass(DifferentWordsMapper.class);
        	job.setReducerClass(DifferentWordsReducer.class);
        	job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(IntWritable.class);
        	
        }else if(args[0].toString().toLowerCase().equals("mr3")) {
        	job.setMapperClass(ScreenameMapper.class);
            job.setReducerClass(ScreenameReducer.class);
            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(IntWritable.class);
        	
        }else if(args[0].toString().toLowerCase().equals("mr4")) {
        	System.out.println("There are no retweets in these files");
        	System.exit(0);
        	
        }else if(args[0].toString().toLowerCase().equals("mr5")) {
        	job.setMapperClass(MessageRepliesMapper.class);
            job.setReducerClass(MessageRepliesReducer.class);
            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(Text.class);
        }else if(args[0].toString().toLowerCase().equals("mr6")) {
        	job.setMapperClass(MessageByUserMapper.class);
            job.setReducerClass(MessageByUserReducer.class);
            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(Text.class);
        }else {
        	System.out.print("Not a vald MR, Try again :( ");
        	System.exit(0);
        }
      

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }

}
