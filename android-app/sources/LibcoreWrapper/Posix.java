package LibcoreWrapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Posix
{
  public Posix() {}
  
  /* Error */
  public static void close(java.io.FileDescriptor paramFileDescriptor)
  {
    // Byte code:
    //   0: ldc 27
    //   2: invokestatic 33	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   5: astore_1
    //   6: aload_1
    //   7: ldc 35
    //   9: invokevirtual 39	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   12: astore_1
    //   13: aload_1
    //   14: iconst_1
    //   15: invokevirtual 45	java/lang/reflect/Field:setAccessible	(Z)V
    //   18: aload_1
    //   19: aconst_null
    //   20: invokevirtual 49	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: astore_1
    //   24: aload_1
    //   25: invokevirtual 53	java/lang/Object:getClass	()Ljava/lang/Class;
    //   28: astore_2
    //   29: aload_2
    //   30: ldc 54
    //   32: iconst_1
    //   33: anewarray 29	java/lang/Class
    //   36: dup
    //   37: iconst_0
    //   38: ldc 56
    //   40: aastore
    //   41: invokevirtual 60	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   44: astore_2
    //   45: aload_2
    //   46: aload_1
    //   47: iconst_1
    //   48: anewarray 4	java/lang/Object
    //   51: dup
    //   52: iconst_0
    //   53: aload_0
    //   54: aastore
    //   55: invokevirtual 66	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   58: pop
    //   59: return
    //   60: astore_0
    //   61: return
    //   62: astore_0
    //   63: return
    //   64: astore_0
    //   65: return
    //   66: astore_0
    //   67: return
    //   68: astore_0
    //   69: return
    //   70: astore_0
    //   71: return
    //   72: astore_0
    //   73: return
    //   74: astore_0
    //   75: return
    //   76: astore_0
    //   77: return
    //   78: astore_0
    //   79: return
    //   80: astore_0
    //   81: return
    //   82: astore_0
    //   83: return
    //   84: astore_0
    //   85: return
    //   86: astore_0
    //   87: return
    //   88: astore_0
    //   89: return
    //   90: astore_0
    //   91: return
    //   92: astore_0
    //   93: return
    //   94: astore_0
    //   95: return
    //   96: astore_0
    //   97: return
    //   98: astore_0
    //   99: return
    //   100: astore_0
    //   101: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	paramFileDescriptor	java.io.FileDescriptor
    //   5	42	1	localObject1	Object
    //   28	18	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	6	60	java/lang/ClassNotFoundException
    //   6	13	62	java/lang/NoSuchFieldException
    //   6	13	64	java/lang/ClassNotFoundException
    //   13	29	66	java/lang/NullPointerException
    //   13	29	68	java/lang/IllegalAccessException
    //   13	29	70	java/lang/IllegalArgumentException
    //   13	29	72	java/lang/NoSuchFieldException
    //   13	29	74	java/lang/ClassNotFoundException
    //   29	45	76	java/lang/NoSuchMethodException
    //   29	45	78	java/lang/NullPointerException
    //   29	45	80	java/lang/IllegalAccessException
    //   29	45	82	java/lang/IllegalArgumentException
    //   29	45	84	java/lang/NoSuchFieldException
    //   29	45	86	java/lang/ClassNotFoundException
    //   45	59	88	java/lang/reflect/InvocationTargetException
    //   45	59	90	java/lang/NullPointerException
    //   45	59	92	java/lang/IllegalAccessException
    //   45	59	94	java/lang/IllegalArgumentException
    //   45	59	96	java/lang/NoSuchMethodException
    //   45	59	98	java/lang/NoSuchFieldException
    //   45	59	100	java/lang/ClassNotFoundException
  }
  
  public static SftpATTRS stat(String paramString)
  {
    try
    {
      localObject1 = Class.forName("libcore.io.Libcore");
    }
    catch (ClassNotFoundException paramString)
    {
      Object localObject1;
      Object localObject2;
      label64:
      for (;;) {}
    }
    try
    {
      localObject1 = ((Class)localObject1).getDeclaredField("os");
    }
    catch (NoSuchFieldException paramString)
    {
      break label64;
    }
    catch (ClassNotFoundException paramString)
    {
      break label64;
    }
    try
    {
      ((Field)localObject1).setAccessible(true);
      localObject1 = ((Field)localObject1).get(null);
      localObject2 = localObject1.getClass();
    }
    catch (NullPointerException paramString)
    {
      break label64;
    }
    catch (IllegalAccessException paramString)
    {
      break label64;
    }
    catch (IllegalArgumentException paramString)
    {
      break label64;
    }
    catch (NoSuchFieldException paramString)
    {
      break label64;
    }
    catch (ClassNotFoundException paramString)
    {
      break label64;
    }
    try
    {
      localObject2 = ((Class)localObject2).getMethod("stat", new Class[] { String.class });
    }
    catch (NoSuchMethodException paramString)
    {
      break label64;
    }
    catch (NullPointerException paramString)
    {
      break label64;
    }
    catch (IllegalAccessException paramString)
    {
      break label64;
    }
    catch (IllegalArgumentException paramString)
    {
      break label64;
    }
    catch (NoSuchFieldException paramString)
    {
      break label64;
    }
    catch (ClassNotFoundException paramString)
    {
      break label64;
    }
    try
    {
      paramString = ((Method)localObject2).invoke(localObject1, new Object[] { paramString });
      return (SftpATTRS)paramString;
    }
    catch (InvocationTargetException paramString)
    {
      break label64;
    }
    catch (NullPointerException paramString)
    {
      break label64;
    }
    catch (IllegalAccessException paramString)
    {
      break label64;
    }
    catch (IllegalArgumentException paramString)
    {
      break label64;
    }
    catch (NoSuchMethodException paramString)
    {
      break label64;
    }
    catch (NoSuchFieldException paramString)
    {
      break label64;
    }
    catch (ClassNotFoundException paramString)
    {
      break label64;
    }
    return null;
  }
}
