package DAY3;
import java.util.*;

class Channel
{
	List<CustomerSubscriber> subs=new ArrayList();
	String vedioTitle;
	void subscribe(CustomerSubscriber sub)
	{
		subs.add(sub);
	}
	
//	unsubscribe
	void unsubscribe(CustomerSubscriber sub)
	{
		subs.remove(sub);
	}
	
	
	void upload(String vedioTitle)
	{
		this.vedioTitle=vedioTitle;
		notifySubscribers();
	}
	void notifySubscribers()
	{
		for(CustomerSubscriber sub1:subs)
		{
			sub1.update();
		}
	}
}

class CustomerSubscriber
{
	
	String name; 
	Channel worldAffairs=new Channel();
	
	CustomerSubscriber(String name)
	{
		this.name=name;
	}
	
	void subscribeChannel(Channel ch)
	{
		worldAffairs=ch;
	}
	void update()
	{
		System.out.println("Hello: "+name+", Vedio uploaded: "+worldAffairs.vedioTitle);
	}
}
public class YoutubeNotification {

	public static void main(String[] args) {
		Channel op=new Channel();
		CustomerSubscriber cs1=new CustomerSubscriber("priyaka");
		CustomerSubscriber cs2=new CustomerSubscriber("Sanskruti");
		CustomerSubscriber cs3=new CustomerSubscriber("akanksha");
		CustomerSubscriber cs4=new CustomerSubscriber("sakshi");
		CustomerSubscriber cs5=new CustomerSubscriber("Tanushri");
		
		op.subscribe(cs1);
		op.subscribe(cs2);
		op.subscribe(cs3);
		op.subscribe(cs4);
		op.subscribe(cs5);
		
		cs1.subscribeChannel(op);
		cs2.subscribeChannel(op);
		cs3.subscribeChannel(op);
		cs4.subscribeChannel(op);
		cs5.subscribeChannel(op);
		
		op.unsubscribe(cs4);
		
		
		op.upload("India-Pakistan Realtion");

	}

}
