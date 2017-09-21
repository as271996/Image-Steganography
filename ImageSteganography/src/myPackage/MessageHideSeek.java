package myPackage;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;


class MessageHideSeek {
 
     public static File getFile()
    {
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(null);
        File imageFile = null;
        if (result == JFileChooser.APPROVE_OPTION)
        {
            imageFile = chooser.getSelectedFile();
        }
        else
        {
            System.out.println("!Error");
        }
        return imageFile;
    }

    public static BufferedImage loadImage(File imageFile)
    {
        BufferedImage image = null;
        try
        {
            image = ImageIO.read(imageFile);
        }
        catch (IOException exception)
        {
            System.out.println("!Error loading image " + exception);
        }
        return image;
    }

    public static String loadMessage(File messageFile)
    {
        String message = "";
        BufferedReader reader = null;
        try
        {
            String line = null;
            reader = new BufferedReader(new FileReader(messageFile));
            while ((line = reader.readLine()) != null)
            {
                message += line;
            }
        }
        catch (IOException exception)
        {
            System.out.println("!Error loading message " + exception);
        }
        finally
        {
            try
            {
                reader.close();
            }
            catch (IOException exception)
            {
                System.out.println("!Error " + exception);
            }
        }
        return message;
    }

    public static String saveImage(BufferedImage image, File imageFile)
    {
        String fileName = imageFile.getName();
        String fileExtension = "HM.png";
        int lastInstanceOf = fileName.lastIndexOf('.');
        String newFileName = fileName.substring(0, lastInstanceOf) + fileExtension;
        try
        {
            ImageIO.write(image, "png", new File(newFileName));
        }
        catch (IOException exception)
        {
            System.out.println("!Error " + exception);
        }
        return newFileName;
    }

    public static byte[] messageToBytes(String message)
    {
        byte[] messageAsBytes = message.getBytes();
        return messageAsBytes;
    }

    public static void alterLSB(byte[] byteArrayToAlter, byte[] byteArrayToEmbed)
    {
        int count = 0;
        for (int i = 0; i < byteArrayToEmbed.length; i++)
        {
            for (int j = 7; j >= 0; j--)
            {
                int bitVal = (byteArrayToEmbed[i] >> j) & 1;
                byteArrayToAlter[count] = (byte)((byteArrayToAlter[count] & 0xFE) | bitVal);
                count++;
            }
        }
    }

    public static String byteToBinayString(byte b)
    {
        StringBuilder sb = new StringBuilder("00000000");
        for (int i = 0; i < 8; i++)
        {
            if(((b >> i) & 1) > 0)
            {
                sb.setCharAt(7 - i, '1');
            }
        }
        return sb.toString();
    }

    public static byte[] messageAsBytesLengthToBytes(byte[] messageAsBytesArray)
    {
        int lengthOfArray = messageAsBytesArray.length;
        byte[] lengthOfArrayAsBytes = new byte[4];
        lengthOfArrayAsBytes[0] = (byte) ((lengthOfArray >>> 24) & 0xFF);
        lengthOfArrayAsBytes[1] = (byte) ((lengthOfArray >>> 16) & 0xFF);
        lengthOfArrayAsBytes[2] = (byte) ((lengthOfArray >>> 8) & 0xFF);
        lengthOfArrayAsBytes[3] = (byte) (lengthOfArray & 0xFF);
        return lengthOfArrayAsBytes;
    }

    private static int byteArrayToInt(byte[] byteArray)
    {
        int anInt = ((byteArray[0] & 0xff) << 24) |
                    ((byteArray[1] & 0xff) << 16) |
                    ((byteArray[2] & 0xff) << 8) |
                     (byteArray[3] & 0xff);
        return anInt;
    }

    public static byte[] augmentByteArrays(byte[] byteArrayA, byte[] byteArrayB)
    {
        byte[] byteArrayC = new byte[byteArrayA.length + byteArrayB.length];
        System.arraycopy(byteArrayA, 0, byteArrayC, 0, byteArrayA.length);
        System.arraycopy(byteArrayB, 0, byteArrayC, byteArrayA.length, byteArrayB.length);
        return byteArrayC;
    }

    public static String extractStringFromImage(BufferedImage image)
    {
        WritableRaster raster = image.getRaster();
        DataBufferByte buffer = (DataBufferByte)raster.getDataBuffer();
        byte[] byteArray = buffer.getData();
        byte[] intAsByteArray = new byte[4];
        int count = 0;
        for (int i = 0; i < intAsByteArray.length; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                int bitVal = byteArray[count] & 1;
                intAsByteArray[i] = (byte)((intAsByteArray[i] << 1) | bitVal);
                count ++;
            }
        }
        int messageBytesSize = MessageHideSeek.byteArrayToInt(intAsByteArray);
        byte[] stringAsByteArray = new byte[messageBytesSize];
        int offset = 32;
        for (int i = 0; i < messageBytesSize; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                int bitVal = byteArray[offset] & 1;
                stringAsByteArray[i] = (byte)((stringAsByteArray[i] << 1) | bitVal);
                offset++;
            }
        }
        String message = new String(stringAsByteArray);
        return message;
    }

    public static byte[] imageToBytes(BufferedImage image)
    {
        byte[]imageAsBytes = null;
        DataBufferByte buffer = (DataBufferByte)image.getRaster().getDataBuffer();
        imageAsBytes = buffer.getData();
        return imageAsBytes;
    } 
}



