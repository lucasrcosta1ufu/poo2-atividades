class Image 
{
    public static InputStream getImage(String path)
    {
        return getClass().getResourceAsStream(path);
    }
}