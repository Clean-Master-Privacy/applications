import java.net.Socket;

final class SocketNode
  implements Runnable
{
  private final Socket socket;
  private final jnamed this$0;
  
  SocketNode(jnamed paramJnamed, Socket paramSocket) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	SocketNode:this$0	Ljnamed;
    //   4: astore_3
    //   5: aload_0
    //   6: getfield 16	SocketNode:socket	Ljava/net/Socket;
    //   9: astore 4
    //   11: aload 4
    //   13: invokevirtual 31	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   16: astore_2
    //   17: new 33	java/io/DataInputStream
    //   20: dup
    //   21: aload_2
    //   22: invokespecial 36	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   25: astore 5
    //   27: aload 5
    //   29: invokevirtual 40	java/io/DataInputStream:readUnsignedShort	()I
    //   32: istore_1
    //   33: iload_1
    //   34: newarray byte
    //   36: astore_2
    //   37: aload 5
    //   39: aload_2
    //   40: invokevirtual 44	java/io/DataInputStream:readFully	([B)V
    //   43: aload_3
    //   44: new 46	org/xbill/DNS/Message
    //   47: dup
    //   48: aload_2
    //   49: invokespecial 48	org/xbill/DNS/Message:<init>	([B)V
    //   52: aload_2
    //   53: iload_1
    //   54: aload 4
    //   56: invokevirtual 54	jnamed:a	(Lorg/xbill/DNS/Message;[BILjava/net/Socket;)[B
    //   59: astore_3
    //   60: aload_3
    //   61: astore_2
    //   62: aload_3
    //   63: ifnonnull +14 -> 77
    //   66: aload 4
    //   68: invokevirtual 57	java/net/Socket:close	()V
    //   71: return
    //   72: aload_2
    //   73: invokestatic 61	jnamed:aA	([B)[B
    //   76: astore_2
    //   77: new 63	java/io/DataOutputStream
    //   80: dup
    //   81: aload 4
    //   83: invokevirtual 67	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   86: invokespecial 70	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   89: astore_3
    //   90: aload_2
    //   91: arraylength
    //   92: istore_1
    //   93: aload_3
    //   94: iload_1
    //   95: invokevirtual 74	java/io/DataOutputStream:writeShort	(I)V
    //   98: aload_3
    //   99: aload_2
    //   100: invokevirtual 77	java/io/DataOutputStream:write	([B)V
    //   103: aload 4
    //   105: invokevirtual 57	java/net/Socket:close	()V
    //   108: return
    //   109: astore_2
    //   110: goto +68 -> 178
    //   113: astore_2
    //   114: getstatic 83	java/lang/System:out	Ljava/io/PrintStream;
    //   117: astore_3
    //   118: new 85	java/lang/StringBuffer
    //   121: dup
    //   122: ldc 87
    //   124: invokespecial 90	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   127: astore 5
    //   129: aload 5
    //   131: aload 4
    //   133: invokevirtual 94	java/net/Socket:getLocalAddress	()Ljava/net/InetAddress;
    //   136: aload 4
    //   138: invokevirtual 97	java/net/Socket:getLocalPort	()I
    //   141: invokestatic 101	jnamed:c	(Ljava/net/InetAddress;I)Ljava/lang/String;
    //   144: invokevirtual 105	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   147: pop
    //   148: aload 5
    //   150: ldc 107
    //   152: invokevirtual 105	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   155: pop
    //   156: aload 5
    //   158: aload_2
    //   159: invokevirtual 110	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   162: pop
    //   163: aload_3
    //   164: aload 5
    //   166: invokevirtual 114	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   169: invokevirtual 119	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   172: aload 4
    //   174: invokevirtual 57	java/net/Socket:close	()V
    //   177: return
    //   178: aload 4
    //   180: invokevirtual 57	java/net/Socket:close	()V
    //   183: aload_2
    //   184: athrow
    //   185: astore_3
    //   186: goto -114 -> 72
    //   189: astore_2
    //   190: return
    //   191: astore_2
    //   192: return
    //   193: astore_2
    //   194: return
    //   195: astore_3
    //   196: goto -13 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	SocketNode
    //   32	63	1	i	int
    //   16	84	2	localObject1	Object
    //   109	1	2	localThrowable	Throwable
    //   113	71	2	localIOException1	java.io.IOException
    //   189	1	2	localIOException2	java.io.IOException
    //   191	1	2	localIOException3	java.io.IOException
    //   193	1	2	localIOException4	java.io.IOException
    //   4	160	3	localObject2	Object
    //   185	1	3	localIOException5	java.io.IOException
    //   195	1	3	localIOException6	java.io.IOException
    //   9	170	4	localSocket	Socket
    //   25	140	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   11	17	109	java/lang/Throwable
    //   17	33	109	java/lang/Throwable
    //   37	43	109	java/lang/Throwable
    //   43	60	109	java/lang/Throwable
    //   72	77	109	java/lang/Throwable
    //   77	90	109	java/lang/Throwable
    //   93	103	109	java/lang/Throwable
    //   114	172	109	java/lang/Throwable
    //   11	17	113	java/io/IOException
    //   17	33	113	java/io/IOException
    //   37	43	113	java/io/IOException
    //   72	77	113	java/io/IOException
    //   77	90	113	java/io/IOException
    //   93	103	113	java/io/IOException
    //   43	60	185	java/io/IOException
    //   66	71	189	java/io/IOException
    //   103	108	191	java/io/IOException
    //   172	177	193	java/io/IOException
    //   178	183	195	java/io/IOException
  }
}
