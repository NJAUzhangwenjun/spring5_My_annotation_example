#  spring5

[TOC]

## 1. Ioc （控制反转，Inverse Of Control）

ico容器叫做控制反转或者是反转控制，将创建和管理类的权利交给spring容器，即ioc只是一个创建和管理类的容器。控制反转。所谓控制反转，就是把创建对象（Bean）和维护对象（Bean）关系的权力从程序中转移到Spring容器中，而程序本身不再负责维护。

容器：其中最底层的代表着是Beanfactory。而ApplicationContext是在Beanfactory的基础上的。

当ClassPathXmlApplicationContext("spring-config.xml")执行的时候，Spring容器对象被创建，同时spring-config中配置的Bean就会被创建（依赖于反射机制）UserService userService =(UserService)applicationContext.getBean("userService");获取Spring容器中的对象。

## 2 .DI

DI（Dependency Injection），依赖注入。所谓依赖注入，实际上，DI和IOC是同一个概念，Spring设计者认为DI能更准确地表示Spring的核心技术。

依赖注入常用set方法注入，而其他比如构造方法注入比较少用。依赖注入可以注入简单数据类型，也可以注入复杂类型，复杂类型需要现在spring配置文件中配置过后，用ref进行注入。



## 3. 常用IOC注解开发

1. ![1563110768143](C:\Users\user\AppData\Roaming\Typora\typora-user-images\1563110768143.png)

2. 注解分类：

   | 相当于创建对象的<bean> | 用于注入数据的<property> | 用于改变作用范围的（scope） | 用于改变生命周期的（init函数和destroy函数的） |
   | ---------------------- | ------------------------ | --------------------------- | --------------------------------------------- |
   | @Compoent              | @Autowired               | @Scope                      | @PreDestroy                                   |
   | @Service               | @Resource                |                             | @PostConstruct                                |
   | @Controller            | @Qualifier               |                             |                                               |
   | @Repostory             | @Value("${数据}")        |                             |                                               |

   *想要用注解，必须添加注解包和开启注解扫描 <context:component-scan base-package="com.njau.account"/>*

   *注意：@Autowired只能按照数据类型自动注入，@Qualifier不能单独使用，@Reseource可以任意注入（不同与前两个，这个属性用 name="id"）。--》》》但是，这是那种数据注入都只能注入复杂数据类型，对简单数据类型无法注入 ，对简单数据只能用@value("${数据}")的方式注入！*

3. 配置类（spring新注解）

   | 注解名称        | 注解作用/注解注意事项                                        | 例子                                                         |
   | --------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
   | @Configuratiuon | 这是一个配置内（当注解是spring主配置的时候可以省略）         | ![1563163281650](C:\Users\user\AppData\Roaming\Typora\typora-user-images\1563163281650.png) |
   | @ComponentScan  | 组件扫描（开启注解，扫描注解的包）                           | ![1563163308362](C:\Users\user\AppData\Roaming\Typora\typora-user-images\1563163308362.png) |
   | @Bean           | 将方法返回值作为Bea放入到容器中，name相当于id，如果没有，默认是方法名 | ![1563167566875](C:\Users\user\AppData\Roaming\Typora\typora-user-images\1563167566875.png) |
   | @Scop           | 控制作用范围，多例还是单例（默认是单例，数据库或取得连接要用多例） | ![1563168783464](C:\Users\user\AppData\Roaming\Typora\typora-user-images\1563168783464.png) |
   | @Import         | 向主配置类中导入其他配置，相当于@ComponentScan(basePackages = {"com.njau","**config**"}) | ![1563170065365](C:\Users\user\AppData\Roaming\Typora\typora-user-images\1563170065365.png) |
   | @PropertySource | 指定properties文件的位置并将数据放入到容器中，取得时候要用@value的方式取（要加classpath指在类路径下）（一般在主配置文件中加这个注解说明properties文件位置） | ![1563171281399](C:\Users\user\AppData\Roaming\Typora\typora-user-images\1563171281399.png) |

   *注意：如果是自己写的类，直接用全部注解开发简单，如果是jar包或者是别人的类，则xml比较省事*

