USE [master]
GO

/****** Object:  Database [FoodWhale]    Script Date: 11/12/2021 12:00:03 AM ******/
CREATE DATABASE [FoodWhale]
GO
ALTER DATABASE [FoodWhale] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [FoodWhale] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [FoodWhale] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [FoodWhale] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [FoodWhale] SET ARITHABORT OFF 
GO
ALTER DATABASE [FoodWhale] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [FoodWhale] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [FoodWhale] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [FoodWhale] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [FoodWhale] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [FoodWhale] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [FoodWhale] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [FoodWhale] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [FoodWhale] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [FoodWhale] SET  ENABLE_BROKER 
GO
ALTER DATABASE [FoodWhale] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [FoodWhale] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [FoodWhale] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [FoodWhale] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [FoodWhale] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [FoodWhale] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [FoodWhale] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [FoodWhale] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [FoodWhale] SET  MULTI_USER 
GO
ALTER DATABASE [FoodWhale] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [FoodWhale] SET DB_CHAINING OFF 
GO
USE [FoodWhale]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 11/12/2021 12:00:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[categoryID] [int] IDENTITY(1,1) NOT NULL,
	[cName] [nvarchar](30) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[categoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Ingredient]    Script Date: 11/12/2021 12:00:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ingredient](
	[inID] [int] IDENTITY(1,1) NOT NULL,
	[inName] [nvarchar](50) NOT NULL,
	[Image] [varchar](255) NOT NULL,
	[Type] [varchar](30) NOT NULL,
	[Price] [money] NOT NULL,
	[categoryID] [int] NOT NULL,
	[description] [nvarchar](50) NOT NULL,
	[guideline] [nvarchar](max) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[inID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Order]    Script Date: 11/12/2021 12:00:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order](
	[oID] [int] IDENTITY(1,1) NOT NULL,
	[uID] [int] NOT NULL,
	[Date] [datetime] NOT NULL,
	[Status] [nvarchar] (15) NULL,
PRIMARY KEY CLUSTERED 
(
	[oID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Order_Detail]    Script Date: 11/12/2021 12:00:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order_Detail](
	[odID] [int] IDENTITY(1,1) NOT NULL,
	[oID] [int] NOT NULL,
	[inID] [int] NOT NULL,
	[Quantity] [int] NOT NULL,
	[Total] [money] NOT NULL,
	[Note] [nvarchar](100) NULL,
	PRIMARY KEY CLUSTERED 
(
	[odID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Recipe]    Script Date: 11/12/2021 12:00:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Recipe](
	[rID] [int] IDENTITY(1,1) NOT NULL,
	[rName] [nvarchar](100) NOT NULL,
	[cID] [int] NOT NULL,
	[Image] [varchar](255) NOT NULL,
	[Difficulty] [varchar](6) NOT NULL,
	[Time] [int] NOT NULL,
	uID int NOT NULL,
	[rDescription] [nvarchar](max) NULL,
	[Guideline1] [nvarchar](max) NULL,
	[Guideline2] [nvarchar](max) NULL,
	[Guideline3] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[rID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Recipe_ingredient]    Script Date: 11/12/2021 12:00:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Recipe_ingredient](
[riID] [int] IDENTITY(1,1) NOT NULL,
	[rID] [int] NOT NULL,
	[inID] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[riID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Recipe_Like]    Script Date: 11/12/2021 12:00:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Recipe_Like](
[rlID] [int] IDENTITY(1,1) NOT NULL,
	[rID] [int] not null,
	[uID] [int] NOT NULL,
	[Fav] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[rlID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User]    Script Date: 11/12/2021 12:00:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[uID] [int] IDENTITY(1,1) NOT NULL,
	[Email] [varchar](50) NOT NULL,
	[Password] [varchar](50) NOT NULL,
	[uName] [varchar](30) NOT NULL,
	[Image] [varchar](255) NOT NULL,
	[DoB] [date] NULL,
	[Gender] [char](1) NULL,
	[Address] [varchar](50) NULL,
	[Phone] [varchar](50) NULL,
	[Role] [varchar](5) NULL,
	[sName] [nvarchar](20) NULL,
	[Status] [nvarchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[uID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Order] ADD  DEFAULT ('Pending') FOR [Status]
GO
ALTER TABLE [dbo].[Recipe_Like] ADD  DEFAULT ('0') FOR [Fav]
GO
ALTER TABLE [dbo].[User] ADD  DEFAULT ('User') FOR [Role]
GO
ALTER TABLE [dbo].[User] ADD  DEFAULT ('Active') FOR [Status]
GO
ALTER TABLE [dbo].[Ingredient]  WITH CHECK ADD  CONSTRAINT [FK_Ingredient_Category] FOREIGN KEY([categoryID])
REFERENCES [dbo].[Category] ([categoryID])
GO
ALTER TABLE [dbo].[Ingredient] CHECK CONSTRAINT [FK_Ingredient_Category]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Order_User] FOREIGN KEY([uID])
REFERENCES [dbo].[User] ([uID])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Order_User]
GO
ALTER TABLE [dbo].[Order_Detail]  WITH CHECK ADD  CONSTRAINT [FK_Order_Detail_Ingredient] FOREIGN KEY([inID])
REFERENCES [dbo].[Ingredient] ([inID])
GO
ALTER TABLE [dbo].[Order_Detail] CHECK CONSTRAINT [FK_Order_Detail_Ingredient]
GO
ALTER TABLE [dbo].[Order_Detail]  WITH CHECK ADD  CONSTRAINT [FK_Order_Detail_Order] FOREIGN KEY([oID])
REFERENCES [dbo].[Order] ([oID])
GO
ALTER TABLE [dbo].[Order_Detail] CHECK CONSTRAINT [FK_Order_Detail_Order]
GO
ALTER TABLE [dbo].[Recipe]  WITH CHECK ADD  CONSTRAINT [FK_Recipe_Category] FOREIGN KEY([cID])
REFERENCES [dbo].[Category] ([categoryID])
GO
ALTER TABLE [dbo].[Recipe] CHECK CONSTRAINT [FK_Recipe_Category]
GO
ALTER TABLE [dbo].[Recipe]  WITH CHECK ADD  CONSTRAINT [FK_Recipe_User] FOREIGN KEY([uID])
REFERENCES [dbo].[User] ([uID])
GO
ALTER TABLE [dbo].[Recipe] CHECK CONSTRAINT [FK_Recipe_User]
GO
ALTER TABLE [dbo].[Recipe_Like]  WITH CHECK ADD  CONSTRAINT [FK_Recipe_Like_Recipe] FOREIGN KEY([rID])
REFERENCES [dbo].[Recipe] ([rID])
GO
ALTER TABLE [dbo].[Recipe_Like] CHECK CONSTRAINT [FK_Recipe_Like_Recipe]
GO
ALTER TABLE [dbo].[Recipe_Like]  WITH CHECK ADD  CONSTRAINT [FK_Recipe_Like_User] FOREIGN KEY([uID])
REFERENCES [dbo].[User] ([uID])
GO
ALTER TABLE [dbo].[Recipe_Like] CHECK CONSTRAINT [FK_Recipe_Like_User]
GO
ALTER TABLE [dbo].[Recipe_ingredient]  WITH CHECK ADD  CONSTRAINT [FK_Recipe_ingredient_Ingredient] FOREIGN KEY([inID])
REFERENCES [dbo].[Ingredient] ([inID])
GO
ALTER TABLE [dbo].[Recipe_ingredient] CHECK CONSTRAINT [FK_Recipe_ingredient_Ingredient]
GO
ALTER TABLE [dbo].[Recipe_ingredient]  WITH CHECK ADD  CONSTRAINT [FK_Recipe_ingredient_Recipe] FOREIGN KEY([rID])
REFERENCES [dbo].[Recipe] ([rID])
GO
ALTER TABLE [dbo].[Recipe_ingredient] CHECK CONSTRAINT [FK_Recipe_ingredient_Recipe]
GO
USE [master]
GO
ALTER DATABASE [FoodWhale] SET  READ_WRITE 
GO

use FoodWhale
go