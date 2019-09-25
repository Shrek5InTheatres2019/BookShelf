package me.MitchT.BookShelf.util;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.bukkit.inventory.ItemStack;

public class ItemStackSerializer {
    /**
     *
     * @param what - The ItemStack to be converted into a string
     * @return The String that contains the ItemStack (will return null if anything goes wrong)
     */
    public static String convertItemStackToString(ItemStack what){
        // serialize the object
        String serializedObject = "";
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream so = new ObjectOutputStream(bo);
            so.writeObject(what);
            so.flush();
            serializedObject = bo.toString();
            return serializedObject;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    /**
     *
     * @param data - The String to be converted into an ItemStack
     * @return The ItemStack Array obtained from the string (will return void should anything go wrong)
     */
    public static ItemStack convertStringToItemStack(String data){
        // deserialize the object
        try {
            byte b[] = data.getBytes();
            ByteArrayInputStream bi = new ByteArrayInputStream(b);
            ObjectInputStream si = new ObjectInputStream(bi);
            ItemStack obj = (ItemStack) si.readObject();
            return obj;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }






    /**
     *
     * @param what - The ItemStack to be converted into a string
     * @return The String that contains the ItemStack (will return null if anything goes wrong)
     */
    public static String convertItemStackArrayToString(ItemStack what[]){
        // serialize the object
        String serializedObject = "";
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream so = new ObjectOutputStream(bo);
            so.writeObject(what);
            so.flush();
            serializedObject = bo.toString();
            return serializedObject;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    /**
     *
     * @param data - The String to be converted into an ItemStack Array
     * @return The ItemStack Array obtained from the string (will return void should anything go wrong)
     */
    public static ItemStack[] convertStringToItemStackArray(String data){
        // deserialize the object
        try {
            byte b[] = data.getBytes();
            ByteArrayInputStream bi = new ByteArrayInputStream(b);
            ObjectInputStream si = new ObjectInputStream(bi);
            ItemStack[] obj = (ItemStack[]) si.readObject();
            return obj;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }



}