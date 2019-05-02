package com.it.slack;

import java.io.IOException;

import com.ullink.slack.simpleslackapi.SlackChannel;
import com.ullink.slack.simpleslackapi.SlackSession;
import com.ullink.slack.simpleslackapi.SlackUser;
import com.ullink.slack.simpleslackapi.events.SlackMessagePosted;
import com.ullink.slack.simpleslackapi.impl.SlackSessionFactory;
import com.ullink.slack.simpleslackapi.listeners.SlackMessagePostedListener;


public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );

      //  SlackSession session = SlackSessionFactory.createWebSocketSlackSession("xoxb-495159405974-610415431939-CFazLKnKE7RNPSvoKj7r03QG");
        SlackSession session = SlackSessionFactory.createWebSocketSlackSession("xoxb-495159405974-610021882289-rmh7BwGppG3bLKHkDyBJu8Fg"); //token alberto
        session.connect();
        /*SlackChannel channel = session.findChannelByName("general"); //make sure bot is a member of the channel.
        session.sendMessage(channel, "hi im a bot" );*/
        System.out.println( "Connesso Adesso collego listner" );
        registeringAListener(session);
        System.out.println( "Listner Collegato" );
        sendDirectMessageToAUser(session,"harwinder95singh@gmail.com");
        System.out.println( "Premi un tasto per spegnere tutto" );

        System.in.read();
        session.disconnect();

    }

    public static void sendDirectMessageToAUser(SlackSession session, String userMail)
    {

        //get a user
        SlackUser user = session.findUserById("UEHU8RWR3");
       //SlackUser user = session.findUserByEmail(userMail);

       
        session.sendMessageToUser(user, "I'm just a happy Bot :doge:",null);
        session.sendMessageToUser(user, ":doge:",null);
        session.sendMessageToUser(user, ":doge:",null);
        session.sendMessageToUser(user, ":doge:",null);
        session.sendMessageToUser(user, ":doge:",null);
        session.sendMessageToUser(user, ":doge:",null);
        session.sendMessageToUser(user, ":doge:",null);
        session.sendMessageToUser(user, ":doge:",null);
        session.sendMessageToUser(user, ":doge:",null);        
        session.sendMessageToUser(user, ":doge:",null);
        session.sendMessageToUser(user, ":doge:",null);
        session.sendMessageToUser(user, ":doge:",null);
        session.sendMessageToUser(user, ":doge:",null);
        session.sendMessageToUser(user, ":doge:",null);
        session.sendMessageToUser(user, ":doge:",null);
        session.sendMessageToUser(user, ":doge:",null);
        session.sendMessageToUser(user, ":doge:",null);
        session.sendMessageToUser(user, ":doge:",null);
        session.sendMessageToUser(user, ":doge:",null);
        session.sendMessageToUser(user, ":doge:",null);
        session.sendMessageToUser(user, ":doge:",null);        
        session.sendMessageToUser(user, ":doge:",null);
        session.sendMessageToUser(user, ":doge:",null);
        session.sendMessageToUser(user, ":doge:",null);
        session.sendMessageToUser(user, ":doge:",null);       
    }


    public static void registeringAListener(SlackSession session)
    {
        // first define the listener
        SlackMessagePostedListener messagePostedListener = new SlackMessagePostedListener()
        {
            @Override
            public void onEvent(SlackMessagePosted event, SlackSession session)
            {
                SlackChannel channelOnWhichMessageWasPosted = event.getChannel();
                String messageContent = event.getMessageContent();
                SlackUser messageSender = event.getSender();
                System.out.println("\n\nContenuto del messaggio: "+ messageContent);
                System.out.println("Sender user ID: "+ messageSender.getId() );
                System.out.println("Sender Name: "+ messageSender.getUserName() );
                System.out.println("Sender Email: "+ messageSender.getUserMail() +"\n\n");
               // session.sendMessage(event.getChannel(),"Message with keyword was sent by the expected user on this channel !");



            }
        };
        //add it to the session
        session.addMessagePostedListener(messagePostedListener);
        
        //that's it, the listener will get every message post events the bot can get notified on
        //(IE: the messages sent on channels it joined or sent directly to it)
    }

}
