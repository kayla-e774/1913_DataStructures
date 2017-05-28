class BinaryVsLinear
{

  private static int linearSearch(int key, int[] array)
  {
      int lcount = 0;
      
      for(int i=0; i < array.length; i++) {
          if(key == array[i]) { 
              lcount += 1;
              break;
          }
          else {
              lcount += 1;
          }
      }
      return lcount;
  }

  private static int binarySearch(int key, int[] array)
  {
      int left = 0;
      int mid;
      int right = array.length - 1;
      int bcount = 0;
      
      while(true) {
          if(left > right) {
              mid = -1;
              break;
          }
          else {
              mid = (left + right) / 2;
              if(key < array[mid]) {
                  right = mid - 1;
                  bcount += 1;
              }
              else if(key > array[mid]) {
                  left = mid + 1;
                  bcount += 2;
              }
              else {
                 bcount += 2;
                 break;
              }
          }
      }
      return bcount;
  }

  public static void main(String[] args)
  {
    for (int length = 1; length <= 30; length += 1)
    {
      int[] array = new int[length];
      for (int index = 0; index < length; index += 1)
      {
        array[index] = index;
      }

      double linearTotal = 0.0;
      double binaryTotal = 0.0;
      for (int element = 0; element < length; element += 1)
      {
        linearTotal += linearSearch(element, array);
        binaryTotal += binarySearch(element, array);
      }

      double linearAverage = linearTotal / length;
      double binaryAverage = binaryTotal / length;
      System.out.println(length + " " + linearAverage + " " + binaryAverage);
    }
  }
}