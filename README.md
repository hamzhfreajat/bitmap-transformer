# bitmap-transformer

## Bitmap
The bitmap class read a bitmap image in from disk, run one or more color or raster transforms and then write it out to a new file. the class manipulating binary data.You can run ./gradlew run --args 'input output transform' to run your application. 

You should add the input path , output path , the type of transform( blackWhite, dark , border ) to your arguments to make the functionality work .   

### Black white 
A method that convert bitmap image from its color to gray or just black and white . 

### Border 
A method that add black border to bitmap image. 

## Dark 
A method that convert bitmap image to more darker image . 