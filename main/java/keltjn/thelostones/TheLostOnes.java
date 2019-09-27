package keltjn.thelostones;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import keltjn.thelostones.lists.ItemList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("thelostones") //tells forge that this is a mod.
public class TheLostOnes 
{
	public static TheLostOnes instance; //creates an instance for our mod to be used
	public static final String modid = "thelostones"; //creates a variable for our modid
	private static final Logger logger = LogManager.getLogger(modid); //gives us a message to the console to make sure everything is working correctly
	
	public TheLostOnes() //this lets all the forge functions run
	{
		instance = this; //references our main mod class outside of our mod class
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup); //It will listen for everything inside the setup method 
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries); //It will listen for everything inside the clientRegistries method
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event) //runs all the setup
	{
		logger.info("Setup method registered"); //it will print out in the console setup method registered
	}
	
	private void clientRegistries(final FMLClientSetupEvent event) //only run on client side like models
	{
		logger.info("clientRegistries method registered"); //it will print out in the console clientRegistaries method registered
	}

	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD) 
	public static class RegsitryEvents //where we register our items
	{
		@SubscribeEvent //creates a new class for RegistryEvents and will run on launch of game
		public static void registerItems(final RegistryEvent.Register<Item> event)
		{
			event.getRegistry().registerAll
			(
					ItemList.onyx_item = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("Onyx")) //creates the object into the game putting it in itemgroup misc and calling the location class to create this item
			);
			
			logger.info("Items registered"); //it will print out in the console
		}
		
		private static ResourceLocation location(String name) 
		{
			return new ResourceLocation(modid, name);
		}
	}
}
