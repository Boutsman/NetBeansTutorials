����   4 �
  �
  �
  �
  � �
  �
  �
 � �
  � �
  �
  �
 � � �
  � �
 � � �
  � �
  �
  � �
  �
 � �
 � �
 � �
 3 � {
 3 � � � � L � \ ~
  �
 � �
 � �
 � �
  �	 � � �
  �
 � �
 � �
  � �
 � � � <init> ()V Code LineNumberTable LocalVariableTable this Ljavaapplication3/Reflection; getObjClassName &(Ljava/lang/Object;)Ljava/lang/String; obj Ljava/lang/Object; mClass Ljava/lang/Class; name Ljava/lang/String; 
simpleName getClassName %(Ljava/lang/Class;)Ljava/lang/String; getAlleConstructors x Ljava/lang/reflect/Constructor; xClass sb Ljava/lang/StringBuilder; c  [Ljava/lang/reflect/Constructor; str StackMapTable � � � M getAlleMethodes method Ljava/lang/reflect/Method; methods [Ljava/lang/reflect/Method; X invokeMethod '(Ljava/lang/Object;Ljava/lang/String;)V e Ljava/lang/Exception; m 
methodName � 
makeObject Ljavaapplication3/Mens; LocalVariableTypeTable Ljava/lang/Class<*>; � &(Ljava/lang/String;)Ljava/lang/Object; 	className � createInstance 8(Ljava/lang/Class;Ljava/lang/Integer;)Ljava/lang/Object; klasse constrNr Ljava/lang/Integer; m1 cons #[Ljava/lang/reflect/Constructor<*>; � � createInstance2 ((Ljava/lang/Class;III)Ljava/lang/Object; param1 I param2 param3 demoChangeArrSize intArray [I newIntArray atr [Ljava/lang/String; str1 changeArraySize '(Ljava/lang/Object;I)Ljava/lang/Object; len arr newArray co print (Ljava/lang/Object;)V i 
SourceFile Reflection.java 4 5 � � � � � � java/lang/StringBuilder � � � � � � � 
 � � � java/lang/Class � � java/lang/Object � � java/lang/Exception � 5 javaapplication3.Mens � � � � javaapplication3/Mens � 5 � � � � � � � � � � � java/lang/String a b d � � � � � � � � � � � � � � 
Array length:  � � � � � � � � �   � � javaapplication3/Reflection java/lang/Integer getClass ()Ljava/lang/Class; getName ()Ljava/lang/String; getSimpleName getConstructors "()[Ljava/lang/reflect/Constructor; java/lang/reflect/Constructor toString append -(Ljava/lang/String;)Ljava/lang/StringBuilder; 
getMethods ()[Ljava/lang/reflect/Method; java/lang/reflect/Method 	getMethod @(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method; invoke 9(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object; printStackTrace forName %(Ljava/lang/String;)Ljava/lang/Class; newInstance ()Ljava/lang/Object; doeIets intValue ()I '([Ljava/lang/Object;)Ljava/lang/Object; valueOf (I)Ljava/lang/Integer; getComponentType java/lang/reflect/Array &(Ljava/lang/Class;I)Ljava/lang/Object; 	getLength (Ljava/lang/Object;)I java/lang/System 	arraycopy *(Ljava/lang/Object;ILjava/lang/Object;II)V isArray ()Z out Ljava/io/PrintStream; (I)Ljava/lang/StringBuilder; java/io/PrintStream println (Ljava/lang/String;)V get -(Ljava/lang/Object;)Ljava/lang/StringBuilder; ! 3        4 5  6   3     *� �    7   
       8        9 :    ; <  6   v     +� M+� � N+� � :-�    7              8   4     9 :      = >    ? @    A B    C B   D E  6   \     +� M+� N,�    7       '  ( 
 ) 8   *     9 :      ? @    A B  
  C B   F E  6   �     D� Y� M+� N-:�66� 2:,� � 	
� 	W����,� :�    7       2  3  4 & 5 5 4 ; 8 A : 8   >  &  G H    D 9 :     D I @   < J K   7 L M  A  N B  O    �   P Q R S S  � "  T E  6   �     D� Y� M+� N-:�66� 2:,� � 	
� 	W����,� :�    7       C  D  E & F 5 E ; I A K 8   >  &  U V    D 9 :     D I @   < J K   7 W X  A  N B  O    �   P Q R Y Y  � "  Z [  6   �     "+� ,� � N-+� � W� 
:� �        7       W  X  [  Y  Z ! \ 8   4    \ ]    " 9 :     " ^ >    " _ B    U V  O    Z `  a 5  6   �     'L� L� M,� M+� � M� N-� ,� �           7   2    d  f  i  g  h  l  o  r  p  q " t & u 8   4    \ ]    \ ]    ' 9 :    % L @    ^ b  c      % L d  O   ' �   P Q  `�   P Q e  `  a f  6   �     %M+� M� N-� N,� � N� 
:� -�    
       7   .    ~  �  � 
 �  �  �  �  �  �  � # � 8   >    \ ]    \ ]    % 9 :     % g B   # L @    ^ b  c      # L d  O   - � 
  P h Q  `�   P h Q e  `  i j  6  >     :N+� � N� 
:� :-� :,� 2� � :� 
:� �   
    - 0   7   2    �  � 
 �  �  �  �  �  � - � 0 � 2 � 7 � 8   R    \ ]  2  \ ]    : 9 :     : k @    : l m   8 L @   # n >    o M  c      8 L d    o p  O   6 �   P Q q Q  `�   P Q q Q r S  `  s t  6  h  	   P:+� � :� 
:� :� :2� Y� SY� SY� S� :� 
:� �        C F   7   2    �  �  �  �  �  �  �   � C � F � H � M � 8   f 
   \ ]  H  \ ]    P 9 :     P k @    P u v    P w v    P x v   M L @   7 = >    0 o M  c      M L d    0 o p  O   6 �   P Q Q  `� /  P Q Q r S  `  y 5  6   �     [�
YOYOYOYOYOL+
� � � M,� � Y SY!SY"SY#SY$SN-
� � %� %:� �    7       �  � % � ) � G � U � Z � 8   4    [ 9 :    C z {  % 6 | {  G  } ~  U   ~  	 � �  6   �     *� � &M,� 'N*� (6*-� )-�    7       �  �  �  �  � 8   4     = >      � v    � @    � >    � v  c       � d  	 � �  6   �     W*� L+� *� �� +� Y� ,� 	*� (� -� � .=*� (� &� +� Y� *� /� 01� 	� � 2���ر    7   "    �  �  �  � ) � 3 � P � V � 8      + + � v    W = >    R L @  c      R L d  O    �  Q� � *  �    �