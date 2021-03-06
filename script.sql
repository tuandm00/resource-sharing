USE [master]
GO
/****** Object:  Database [ResourceSharing]    Script Date: 26/5/2021 8:26:25 AM ******/
CREATE DATABASE [ResourceSharing]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'ResourceSharing', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER1\MSSQL\DATA\ResourceSharing.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'ResourceSharing_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER1\MSSQL\DATA\ResourceSharing_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [ResourceSharing] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ResourceSharing].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [ResourceSharing] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ResourceSharing] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ResourceSharing] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ResourceSharing] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ResourceSharing] SET ARITHABORT OFF 
GO
ALTER DATABASE [ResourceSharing] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [ResourceSharing] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ResourceSharing] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ResourceSharing] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ResourceSharing] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ResourceSharing] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ResourceSharing] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ResourceSharing] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ResourceSharing] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ResourceSharing] SET  DISABLE_BROKER 
GO
ALTER DATABASE [ResourceSharing] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ResourceSharing] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ResourceSharing] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ResourceSharing] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ResourceSharing] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ResourceSharing] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ResourceSharing] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ResourceSharing] SET RECOVERY FULL 
GO
ALTER DATABASE [ResourceSharing] SET  MULTI_USER 
GO
ALTER DATABASE [ResourceSharing] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ResourceSharing] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ResourceSharing] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ResourceSharing] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [ResourceSharing] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [ResourceSharing] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'ResourceSharing', N'ON'
GO
ALTER DATABASE [ResourceSharing] SET QUERY_STORE = OFF
GO
USE [ResourceSharing]
GO
/****** Object:  Table [dbo].[tblBooking]    Script Date: 26/5/2021 8:26:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblBooking](
	[bookingID] [int] IDENTITY(1,1) NOT NULL,
	[userID] [nvarchar](50) NULL,
	[totalPrice] [float] NULL,
	[dateGo] [datetime] NULL,
	[status] [nvarchar](50) NULL,
	[duration] [nvarchar](50) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblProducts]    Script Date: 26/5/2021 8:26:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblProducts](
	[productID] [nvarchar](50) NULL,
	[productName] [nvarchar](50) NULL,
	[price] [float] NULL,
	[quantity] [int] NULL,
	[color] [nvarchar](50) NULL,
	[categoryID] [nvarchar](50) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblUsers]    Script Date: 26/5/2021 8:26:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblUsers](
	[userID] [nvarchar](50) NULL,
	[password] [nvarchar](50) NULL,
	[name] [nvarchar](50) NULL,
	[roleID] [nvarchar](50) NULL,
	[phone] [nvarchar](50) NULL,
	[address] [nvarchar](50) NULL,
	[createDate] [datetime] NULL,
	[captcha] [nvarchar](50) NULL,
	[email] [nvarchar](50) NULL,
	[status] [nvarchar](50) NULL
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[tblBooking] ON 

INSERT [dbo].[tblBooking] ([bookingID], [userID], [totalPrice], [dateGo], [status], [duration]) VALUES (1, N'user', 100000, CAST(N'2021-05-25T23:28:53.497' AS DateTime), NULL, NULL)
INSERT [dbo].[tblBooking] ([bookingID], [userID], [totalPrice], [dateGo], [status], [duration]) VALUES (2, N'user', 100000, CAST(N'2021-05-25T23:29:33.353' AS DateTime), NULL, NULL)
INSERT [dbo].[tblBooking] ([bookingID], [userID], [totalPrice], [dateGo], [status], [duration]) VALUES (3, N'user', 220000, CAST(N'2021-05-25T23:30:25.667' AS DateTime), NULL, NULL)
INSERT [dbo].[tblBooking] ([bookingID], [userID], [totalPrice], [dateGo], [status], [duration]) VALUES (4, N'user', 220000, CAST(N'2021-05-25T23:31:17.513' AS DateTime), NULL, NULL)
INSERT [dbo].[tblBooking] ([bookingID], [userID], [totalPrice], [dateGo], [status], [duration]) VALUES (7, N'user', 100000, CAST(N'2021-05-25T23:35:00.507' AS DateTime), NULL, N'6')
INSERT [dbo].[tblBooking] ([bookingID], [userID], [totalPrice], [dateGo], [status], [duration]) VALUES (8, N'user', 100000, CAST(N'2021-05-25T23:36:25.513' AS DateTime), NULL, N'6')
INSERT [dbo].[tblBooking] ([bookingID], [userID], [totalPrice], [dateGo], [status], [duration]) VALUES (9, N'user', 100000, CAST(N'2021-05-25T23:37:04.030' AS DateTime), NULL, NULL)
INSERT [dbo].[tblBooking] ([bookingID], [userID], [totalPrice], [dateGo], [status], [duration]) VALUES (5, N'user', 100000, CAST(N'2021-05-25T23:31:20.817' AS DateTime), NULL, NULL)
INSERT [dbo].[tblBooking] ([bookingID], [userID], [totalPrice], [dateGo], [status], [duration]) VALUES (6, N'user', 100000, CAST(N'2021-05-25T23:34:20.657' AS DateTime), NULL, NULL)
SET IDENTITY_INSERT [dbo].[tblBooking] OFF
GO
INSERT [dbo].[tblProducts] ([productID], [productName], [price], [quantity], [color], [categoryID]) VALUES (N'1', N'Acer', 100000, 100, N'black', N'1')
INSERT [dbo].[tblProducts] ([productID], [productName], [price], [quantity], [color], [categoryID]) VALUES (N'2', N'Asus', 200000, 100, N'red', N'2')
INSERT [dbo].[tblProducts] ([productID], [productName], [price], [quantity], [color], [categoryID]) VALUES (N'3', N'Msi', 150000, 100, N'white', N'3')
INSERT [dbo].[tblProducts] ([productID], [productName], [price], [quantity], [color], [categoryID]) VALUES (N'4', N'Acer', 120000, 100, N'gold', N'1')
INSERT [dbo].[tblProducts] ([productID], [productName], [price], [quantity], [color], [categoryID]) VALUES (N'5', N'Asus', 220000, 100, N'gray', N'2')
INSERT [dbo].[tblProducts] ([productID], [productName], [price], [quantity], [color], [categoryID]) VALUES (N'6', N'Msi', 170000, 100, N'pink', N'3')
INSERT [dbo].[tblProducts] ([productID], [productName], [price], [quantity], [color], [categoryID]) VALUES (N'7', N'Macbook', 300000, 100, N'white', N'4')
INSERT [dbo].[tblProducts] ([productID], [productName], [price], [quantity], [color], [categoryID]) VALUES (N'8', N'Macbook', 320000, 100, N'gray', N'4')
INSERT [dbo].[tblProducts] ([productID], [productName], [price], [quantity], [color], [categoryID]) VALUES (N'9', N'Dell', 100000, 100, N'black', N'5')
INSERT [dbo].[tblProducts] ([productID], [productName], [price], [quantity], [color], [categoryID]) VALUES (N'10', N'Dell', 120000, 100, N'purple', N'5')
GO
INSERT [dbo].[tblUsers] ([userID], [password], [name], [roleID], [phone], [address], [createDate], [captcha], [email], [status]) VALUES (N'user', N'1', N'tuan', N'US', N'123123', N'sg', CAST(N'2021-05-25T22:24:45.277' AS DateTime), NULL, NULL, NULL)
GO
ALTER TABLE [dbo].[tblBooking] ADD  CONSTRAINT [DF_tblBooking_dateGo]  DEFAULT (getdate()) FOR [dateGo]
GO
ALTER TABLE [dbo].[tblUsers] ADD  CONSTRAINT [DF_tblUsers_createDate]  DEFAULT (getdate()) FOR [createDate]
GO
USE [master]
GO
ALTER DATABASE [ResourceSharing] SET  READ_WRITE 
GO
