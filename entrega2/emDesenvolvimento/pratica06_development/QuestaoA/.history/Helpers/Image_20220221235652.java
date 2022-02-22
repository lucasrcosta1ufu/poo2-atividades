class Image 
{
    public static InputStream getStream(String path)
    {
        return getClass().getResourceAsStream(path);
    }

    public static ImageIO getImage(String path) throws IOException
    {        
        return ImageIO.read(Image.getStream(String path));
    }
}