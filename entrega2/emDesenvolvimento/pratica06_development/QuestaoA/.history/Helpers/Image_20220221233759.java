class Image 
{
    public static InputStream getStream(String path)
    {
        return getClass().getResourceAsStream(path);
    }

    public static InputStream getImage(String path)
    {
        return Image.getStream(String path);
    }
}