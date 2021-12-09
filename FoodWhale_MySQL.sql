CREATE DATABASE FoodWhale;
use FoodWhale;
CREATE TABLE `User`(
	uID int NOT NULL auto_increment,
	Email varchar(50) NOT NULL,
	Password varchar(50) NOT NULL,
	uName varchar(30) NOT NULL,
	Image varchar(255) NOT NULL,
	DoB date NULL,
	Gender char(1) NULL,
	Address varchar(50) NULL,
	Phone varchar(50) NULL,
	Role varchar(5) NULL default 'User', 
	sName varchar(20) NULL,
	Status varchar(20) NULL default 'Active',
    primary key (uID)
    );
ALTER TABLE User AUTO_INCREMENT=1;

CREATE TABLE Category(
	categoryID int NOT NULL auto_increment,
	cName varchar (30) NOT NULL,
    primary key (categoryID)
    );
ALTER TABLE Category AUTO_INCREMENT=1;

CREATE TABLE Ingredient(
	inID int NOT NULL auto_increment,
	inName varchar(100) NOT NULL,
	Image varchar(255) NOT NULL,
	Type varchar(30) NOT NULL,
	Price double NOT NULL,
	categoryID int NOT NULL,
	description varchar(100) NULL,
    guideline varchar(255) NULL,
    primary key (inID),
    foreign key (categoryID) references Category(categoryID)
    );
ALTER TABLE Ingredient AUTO_INCREMENT=1;

CREATE TABLE `Order`(
	oID int NOT NULL auto_increment,
	uID int NOT NULL,
	Date datetime NOT NULL,
    Total double NOT NULL,
    Note varchar(100) NULL,
	Status varchar (15) NULL default 'Pending',
    primary key (oID),
    foreign key (uID) references `User`(uID)
    );
ALTER TABLE `Order` AUTO_INCREMENT=1;

CREATE TABLE Order_Detail(
	odID int NOT NULL auto_increment,
	oID int NOT NULL,
	inID int NOT NULL,
	Quantity int NOT NULL,
    primary key (odID),
    foreign key (oID) references `Order`(oID),
    foreign key (inID) references Ingredient(inID)
    );
ALTER TABLE Order_Detail AUTO_INCREMENT=1;

CREATE TABLE Recipe(
	rID int NOT NULL auto_increment,
	rName varchar(100) NOT NULL,
	cID int NOT NULL,
	Image varchar(255) NOT NULL,
	Difficulty varchar(6) NOT NULL,
	`Time` int NOT NULL,
	uID int NOT NULL,
	rDescription varchar (1000) NULL,
	Guideline1 text(65535) NULL,
	Guideline2 text(65535) NULL,
	Guideline3 text(65535) NULL,
    primary key (rID),
    foreign key (cID) references Category(categoryID),
    foreign key (uID) references `User`(uID)
    );
ALTER TABLE Recipe AUTO_INCREMENT=1;

CREATE TABLE Recipe_ingredient(
    riID int NOT NULL auto_increment,
	rID int NOT NULL,
	inID int NOT NULL,
    primary key (riID),
    foreign key (rID) references Recipe(rID),
    foreign key (inID) references Ingredient(inID)
    );
ALTER TABLE Recipe_ingredient AUTO_INCREMENT=1;

CREATE TABLE Recipe_Like(
	rlID int NOT NULL auto_increment,
	rID int not null,
	uID int NOT NULL,
	Fav boolean NULL default '0',
    primary key (rlID),
    foreign key (rID) references Recipe(rID),
    foreign key (uID) references `User`(uID)
    );
ALTER TABLE Recipe_Like AUTO_INCREMENT=1;


Insert into `User`(Email, Password, uName, Image, DoB, Gender, Address, Phone, Role) values ('ha', '12345678', 'ha', 'ha', '2001-08-20', 'm', 'Bac Giang', '0982765291', 'Admin');
Insert into `User`(Email, Password, uName, Image, DoB, Gender, Address, Phone, Role) values ('nghia', '12345678', 'nghia', 'nghia', '2002-11-26', 'm', 'Cao Bang', '0837286866', 'Admin');
Insert into `User`(Email, Password, uName, Image, DoB, Gender, Address, Phone, Role) values ('quoc', '12345678', 'quoc', 'quoc', '2001-01-01', 'm', 'Ha Noi', '1234567891', 'Admin');
Insert into `User`(Email, Password, uName, Image, DoB, Gender, Address, Phone, Role) values ('minh', '12345678', 'minh', 'minh', '2001-01-01', 'm', 'Ha Noi', '1234567891', 'Admin');
Insert into `User`(Email, Password, uName, Image, DoB, Gender, Address, Phone, Role) values ('anh', '12345678', 'anh', 'anh', '2001-01-01', 'm', 'Ha Noi', '1234567891', 'Admin');

Insert into Category(cName) values ('Pizza Recipes');
Insert into Category(cName) values ('Salad Recipes');
Insert into Category(cName) values ('Potatoes Recipes');
Insert into Category(cName) values ('Hamburger');
Insert into Category(cName) values ('Main dish');
Insert into Category(cName) values ('Spaghetti');

Insert into Category(cName) values ('Seasoning');
Insert into Category(cName) values ('Vegetable');
Insert into Category(cName) values ('Cheese');
Insert into Category(cName) values ('SeaFood');
Insert into Category(cName) values ('Meat');
Insert into Category(cName) values ('Oil');
Insert into Category(cName) values ('Dough');

Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values('Pizza Base','https://i.ytimg.com/vi/sLfp4T1dxhU/maxresdefault.jpg','20Cm' , '5','13' ,'Pizza Base for Pizza','Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Onion','https://dictionary.cambridge.org/vi/images/thumb/onion_noun_001_11239.jpg?version=5.0.199','500g' , '1','8' ,'Hành tây' ,'Bảo quản nơi khô ráo tránh ánh nắng trực tiếp');
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Bell Pepper','https://hosstools.com/wp-content/uploads/2020/10/mini-belle-pepper-mix.jpg','500g' , '5','8' ,'Ớt chuông' ,'Bảo quản trong tủ lạnh' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Butter','https://cdn.tgdd.vn/2020/07/CookProduct/cach-lam-bo-butter-bang-kem-tuoi-heavy-cream-1-1200x676.jpg','500g' , '5','1' ,'Bơ động vật' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Mozzarella Cheese','https://santorino.org/wp-content/uploads/2020/11/pho-mai-bao-mozzarella-uruguay.jpg','500g' , '10','9' ,'Phô Mai Kéo sợi' ,'Bảo quản nơi khô ráo thoáng mát tránh ánh nắng trực tiếp' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Tomato Sauce','https://salt.tikicdn.com/ts/product/2e/d2/f1/ff2fd0f01c5c89ce6a5faead91d65032.png','500ml' , '4','1' ,'Sốt cà chua đóng hộp' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Beef','https://hanoismallgoods.com/wp-content/uploads/2021/05/beef-cheek-2.jpg','1kg' , '15','11' ,'Thịt bò mỹ' ,'Bảo quản ngăn mát tủ lạnh, tránh ánh nắng trực tiếp' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('PineApple','https://vcdn-vnexpress.vnecdn.net/2017/03/09/pineapple-1268-1489051642.jpg','500g' , '2','8' ,'Dứa ngọt' ,'Bảo quản nơi khô ráo' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Sweet Corn','http://bizweb.dktcdn.net/thumb/grande/100/408/264/products/5116776ngo-ngot-sweet-corn-000000002462-jpeg.jpg?v=1603792320133','1kg' , '5','8' ,'Ngô Ngọt' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Squid','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQcVSqoV9gOlFlOrVaT11Q5yAad4qPl9OBI-g&usqp=CAU','500g' , '10','10' ,'Mực ống' ,'Bảo quản ngăn mát tủ lạnh' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Shrimp','https://solidstarts.com/wp-content/uploads/Shrimp-for-Babies-scaled.jpg','500g' , '8','10' ,'Tôm Sú' ,'Bảo quản ngăn mát tủ lạnh' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Minced garlic','https://vn-test-11.slatic.net/p/c4a542e2652df3bc2068f7bc70217a46.jpg','100g' , '2','7' ,'Tỏi băm' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Oregano','https://lh3.googleusercontent.com/proxy/2w2I6mfMTo6dXqNEzVQFeRjqVr735yDJmGpv-U0WewahkFYsq8DpFlNvA_PJolaqAO9freYjKYsj46yyK3OclRaAP0aG2AybqxEh9gE3CMprcKYgQHFHhb-wdVBnxlE3jH-X0rbvuRRpser4iw','100g' , '3','7' ,'Kinh giới sấy khô' ,'Bảo quản nơi khô ráo' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Chicken breast','https://www.foodiecrush.com/wp-content/uploads/2018/08/Instant-Pot-Chicken-Breasts-foodiecrush.com-006A.jpg','500g' , '8','11' ,'Ức gà ta' ,'Bảo quản ngăn mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Sausage','https://i0.wp.com/hanoismallgoods.com/wp-content/uploads/2021/04/spiced-lamb-sausage.jpg','500g' , '4','1' ,'Xúc xích Đức Việt' ,'Bảo quản ngăn mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Salt','https://media.istockphoto.com/photos/crystals-of-shallow-salt-in-a-scoop-spoon-on-a-dark-gray-table-for-picture-id1051727580?k=20&m=1051727580&s=612x612&w=0&h=v3gWwwVtHrz6fNouAUAydniYE9SedKbORry0cE-Kzq0=','1kg' , '1','7' ,'Muối tinh' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Sugar','https://1.bp.blogspot.com/-vg93ooJdZr8/XhYcsMiWbtI/AAAAAAAAB8k/jO-UA3qtanU4_jj5Va_UQth5PD6WjJtGgCLcBGAsYHQ/s640/sugar-la-gi.jpg','1kg' , '1','7' ,'Đường ' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Seasoning seeds','https://www.sonnentor.com/at/product-images/00323/image-thumb__65732__thumb-slider/brotgeweurz_ganz_WEBSITE.jpeg','500g' , '3','7' ,'Gia vị ' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Olive oil','https://lh3.googleusercontent.com/proxy/gmIbXf-LQQM_HhnglP_C9Xa-jBNW6M0Nv5rO0BIO2Dbaa1c1VrxaghuE7BFfR7iyOtKFzT_5QHBM20t-QK0NPqAO9IBfwgr0pg1nQ2V_nynHMh9TjJ-soLtRhsftq64','500ml' , '20','12' ,'Dầu olive' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Grated Cheese','https://produits.bienmanger.com/38243-0w470h470_Badoz_Grated_Cheese_For_Cheese_Fondue.jpg','1kg' , '15','9' ,'Phô mai bào' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Basil','https://cdn.daylambanh.edu.vn/wp-content/uploads/2019/06/basil-la-gi.jpg','200g' , '4','7' ,'Húng quế' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Roman Lettuce','https://cdn.shopify.com/s/files/1/0509/8173/2535/products/moreecoliill.jpg?v=1629176803','100g' , '1','8' ,'Xà lách Roman' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Bread','https://upload.wikimedia.org/wikipedia/commons/0/0f/Serbian_bread.jpg','100g' , '1','13' ,'Bánh mì' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Canned Fish','https://sc04.alicdn.com/kf/U32d895585ee94989a3a234e127ca0094X.jpg','300g' , '6','10' ,'Cá đóng hộp' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Unsalted Butter','https://product.hstatic.net/1000282430/product/unsalted-butter-anchor-227g_2ae3edfcc7d4481f8db2bb1c52fd04f7_large.jpg','500g' , '15','2' ,'Bơ nhạt' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Dijon Mustard','https://m.media-amazon.com/images/I/41bUsaQvGGL.jpg','50g' , '5','7' ,'Mù tạt dijon' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Chicken Egg','https://www.australianeggs.org.au/assets/tiles/How-chickens-make-eggs__FocusFillWyIwLjAwIiwiMC4wMCIsMTIwMCw2Mjhd.jpg','1 quả' , '1','2' ,'Trứng gà ta' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Lemon','https://upload.wikimedia.org/wikipedia/commons/thumb/e/e4/Lemon.jpg/1024px-Lemon.jpg','1 quả' , '1','8' ,'Chanh vàng' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Garlic','http://nasol.com.vn/Uploads/images/tin%20t%E1%BB%A9c/TIN%20TUC/chiet-xuat-toi.jpg','100g' , '6','7' ,'Tỏi' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Parmesan Cheese','https://cdn.cet.edu.vn/wp-content/uploads/2019/04/parmesan-la-gi.jpg','500g' , '20','9' ,'Phô mai Parnesan' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Vegetable Oil','https://i5.walmartimages.com/asr/e619efe0-990c-473e-bcc0-f2ba4da78252.60998c9abf70659a317eb43697bc39da.jpeg','500ml' , '25','12' ,'Dầu thực vật' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Sanwich','https://cdn.tgdd.vn/2020/11/CookRecipe/GalleryStep/thanh-pham-432.jpg','1 cái' , '1','13' ,'Bánh sanwich' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Rosemary','https://trankinhan.com/wp-content/uploads/2019/08/Tim-hieu-ve-cay-huong-thao-Rosemary-1.jpg','200g' , '6','7' ,'Rosemary' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Yellow mustard','https://produits.bienmanger.com/27673-0w600h600_French_Classic_Yellow_Mustard.jpg','50g' , '6','7' ,'Mù tạt Vàng' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Canned Fish anchovy','https://m.media-amazon.com/images/I/61odrkS7Q0L._SL1000_.jpg','300g' , '7','10' ,'Cá hộp anchovy' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Potatoes','https://sc04.alicdn.com/kf/Ub6c21d80565841e99c7fbf2bfa776fc2a.jpg','500g' , '8','8' ,'Khoai tây' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Milk','https://cdn.tgdd.vn/Products/Images/2386/92114/bhx/thung-12-hop-sua-tuoi-tiet-trung-th-true-milk-nguyen-chat-hop-1-lit-201903131359109964.jpg','500ml' , '4','3' ,'Sữa' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Peper','https://5.imimg.com/data5/VL/QI/EM/ANDROID-38962981/1564424969436-jpg-500x500.jpg','100g' , '3','7' ,'Hạt tiêu' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Bacon','https://www.hoidaubepaau.com/wp-content/uploads/2018/11/thit-nac.jpg','500g' , '15','11' ,'Thịt heo xông khói' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Cheese Sliced','https://cf.shopee.vn/file/541c546235dd604d0c0ec30781f1e4df','500g' , '9','9' ,'Phô mai cắt lát' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Salted butter','https://product.hstatic.net/1000282430/product/salted-butter-anchor-250g_1e0aecc0c4cd460aa98ebcd9fc69132c_large.jpg','500g' , '11','3' ,'Bơ mặn' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Yogurt','https://cdn.dayphache.edu.vn/wp-content/uploads/2021/03/greek-yogurt.jpg','1 hộp' , '1','3' ,'Sữa chua' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Thyme ','https://lh3.googleusercontent.com/proxy/aOonpXmErujR7PvKOeTZ26wN5611mOMjYCwsnYLipcKPArgU_jE_DQgczAKkmZc6Bmvr6DxRpNQTTqcgSaC3nRinjul9-GeeHJnv1sDTJS6qNn_rudQAr4RDd2Ouq0Tvfc7Y22b3J5fbi-tbAROYRATn','100g' , '4','7' ,'Xạ hương' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Dough','https://3f4c2184e060ce99111b-f8c0985c8cb63a71df5cb7fd729edcab.ssl.cf2.rackcdn.com/media/16863/all-purposebreaddough.jpg','2 cái' , '3','4' ,'Bột bánh' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Carrots','https://luxuryfoods.vn/wp-content/uploads/2020/12/unnamed-1-1.jpg','500g' , '6','8' ,'Cà rốt' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('White reishi mushroom','https://thumbs.dreamstime.com/z/fresh-white-beech-mushroom-white-reishi-mushroom-plate-white-beech-mushroom-white-reishi-mushroom-233039121.jpg','500g' , '16','8' ,'Nấm Reishi trắng' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Oyster Oil','https://dl.airtable.com/.attachments/7bd18b26b0acf4ef45f2427e8c475392/496e273e/IMG_1928.jpg-large2x.jpg','500ml' , '25','12' ,'Dầu Oyster' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Red wine','https://winevn.com/wp-content/uploads/2021/06/Ruou-Vang-Coppola-Eleanor-Red-Wine.jpg','500ml' , '40','5' ,'Rượu Vang đỏ' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Spaghetti','https://www.collinsdictionary.com/images/full/spaghetti_175767539.jpg','500g' , '10','6' ,'Mỳ ý' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Spaghetti Sauce','https://iheartvegetables.com/wp-content/uploads/2021/05/Meatless-Spaghetti-Sauce-20-of-25.jpg','500g' , '20','6' ,'Sốt Mỳ ý' ,'Bảo quản nơi khô ráo thoáng mát' );

Insert into Recipe(rName, cID, Image, Difficulty, Time, uID, rDescription, Guideline1, Guideline2, Guideline3) values ('Pizza SeaFood','1','https://cdn.tgdd.vn/2020/09/CookRecipe/Avatar/pizza-hai-san-pho-mai-thumbnail.jpg','Easy','90','4',
'Pizza made from sea food',
'Sơ chế và ướp hải sản:
Tôm bạn lột sạch vỏ, loại bỏ hết đầu và đuôi, dùng dao rạch 1 đường trên lưng tôm để dễ dàng lấy hết phần chỉ tôm.
Mực ống mua về lột sạch phần da bên ngoài, rửa sạch và cắt khoanh tròn là được.
Cho vào phần tôm và mực 1/2 thìa muối, 1/2 thìa đường, 1/2 thìa tiêu và 1 thìa hạt nêm. Trộn đều và để yên cho thấm vị trong khoảng 10 phút.',
'Sơ chế nguyên liệu khác:
Ớt chuông mua về rửa sạch, cắt miếng vuông nhỏ khoảng 1 - 2 lóng tay. Hành tím cắt lát dạng khoanh tròn. Ớt cắt lát mỏng, loại hết hạt đi là được.
Xào hải sản:
Bắc lên bếp 1 cái chảo chờ nóng phi thơm hành và tỏi băm. Cho hết hải sản vào xào với lửa lớn cho săn đều là có thể tắt bếp.
Cho nhân lên đế bánh
Phết đều 1 lớp tương cà lên trên mặt đế bánh pizza, xếp lên trên lần lượt hết phần hành tím, ớt chuông, phô mai trải đều mặt bánh.
Thêm hải sản và vài lát ớt lên trên và chuẩn bị nướng, có thể thêm 1 lớp phô mai nữa ở trên cùng nếu thích.',
'Nướng bánh:
Cách 1: Nướng pizza bằng lò nướng
Đầu tiên, bạn cần phải mở lò nướng trước để làm nóng lò, mở ở nhiệt độ 200 độ C trong vòng 10 - 15 phút. Khi đủ thời gian cho bánh vào nướng ở nhiệt độ 230 độ C trong khoảng 7 phút là được.
Cách 2: Nướng pizza bằng nồi chiên không dầu
Đối với nồi chiên không dầu, trước khi nướng bạn làm nóng lò 5 phút ở nhiệt 180 độ, sau đo bạn nướng bánh pizza ở 200 độ C trong vòng 10 phút.
Thành phẩm:
Chiếc bánh pizza nóng giòn thơm béo ra lò với phần hải sản quyện lẫn trong lớp phô mai béo ngậy ăn kèm với ớt chuông càng thêm hấp dẫn.
Lưu lại ngay công thức và vào bếp trổ tài cho cả nhà thưởng thức ngay nào!');

Insert into Recipe(rName, cID, Image, Difficulty, Time, uID, rDescription, Guideline1, Guideline2, Guideline3) values ('Pineapple beef pizza','2','https://cdn.tgdd.vn/2020/08/CookRecipe/Avatar/pizza-bo%CC%80-du%CC%81a-thumbnail.jpg','Easy','60' ,'4',
'Pizza made with Pineapple and beef',
'Sơ chế nguyên liệu
Thịt bò rửa sạch, băm nhuyễn. Bắp ngọt bóc vỏ, làm sạch râu và tách thành hạt hoặc dùng dao rọc. Tỏi bóc vỏ, băm nhuyễn
Hành tây bỏ vỏ, rửa sạch, một phần bạn cắt sợi vừa ăn, một phần bạn băm nhuyễn . Ớt chuông rửa sạch, bỏ hạt và cắt sợi. Dứa bỏ vỏ, cắt mắt, rửa sạch và cắt thành miếng tam giác.',
'Xào nhân:
Bạn cho dầu lên chảo, khi dầu nóng già, cho tỏi băm, hành tây băm và lá oregano vào phi thơm. Khi nguyên liệu vàng, bạn cho thịt bò vào xào cùng 2 muỗng canh sốt cà chua.
Sau đó, bạn cho bắp ngọt cùng 1 muỗng canh đường, nửa muỗng cà phê muối rồi đảo đều.
Cho nhân lên đế bánh
Để đế bánh được giòn hơn, nướng đế bánh ở nhiệt độ 180 độ trong vòng 3 phút với nồi chiên không dầu.
Sau 3 phút, bạn lấy bánh ra và phết tương cà đều mặt bánh, cho phô mai lên trên, tiếp theo là sốt bò, dứa, hành tây, ớt chuông và cuối cùng là một lớp phô mai nữa.
Nướng bánh pizza',
'Cách 1: Nướng pizza bằng nồi chiên không dầu
Bạn nướng bằng nồi chiên không dầu ở nhiệt độ 200 độ C trong vòng 10 phút
Cách 2: Nướng pizza bằng lò nướng
Làm nóng lò 10 phút ở nhiệt độ 200 độ C trước khi nướng. Bạn nướng bằng lò nướng ở nhiệt độ 200 độ C trong vòng 10 phút đối với bánh đế giòn, 7 phút đối với bánh đế mềm.
Thành phẩm
Pizza bò dứa nóng hổi đã ra lò, pizza giòn và mềm, thịt bò thơm, bắp ngọt và rau củ tươi mát khiến ai cũng phải xuýt xoa. Bánh sẽ còn ngon hơn khi bạn ăn kèm với tương ớt hoặc sốt mayonnaise đó.
');

Insert into Recipe(rName, cID, Image, Difficulty, Time, uID, rDescription, Guideline1, Guideline2, Guideline3) values ('Cheese chicken pizza','3','https://cdn.tgdd.vn/2020/09/CookRecipe/GalleryStep/tha%CC%80nh-pha%CC%89m-8.jpg','Easy','60' ,'4',
'Pizza made with Cheese and chicken',
'Sơ chế rau củ
Ớt chuông rửa sạch, dùng mũi dao tách phần cuống sau đó cắt ớt thành khoanh. Hành tím bóc vỏ, cắt lát. Xúc xích cắt khoanh.
Sơ chế thịt gà
Thịt ức gà bạn rửa sạch, để ráo, cắt khúc vừa và ướp với 5gr muối, 5gr hạt nêm, 5gr tiêu, 2gr đường sau đó trộn đều và ướp gà 15 phút.
Chiên và xé gà',
'Cho 50ml dầu vào chảo, khi dầu sôi bạn cho gà vào và chiên chín mềm. Khi gà chín, bạn xé gà thành từng thớ thịt mỏng vừa ăn.
Cho nhân lên đế bánh
Trước tiên, bạn cho tương cà lên trên và phết đều bề mặt. Tiếp theo, bạn cho xen kẽ ớt chuông, hành tím, sau đó là gà xé, xúc xích và cuối cùng là phô mai Mozzarella.
Nướng bánh',
'Nướng pizza bằng lò nướng
Khi bạn sử dụng lò để nướng bánh, trước tiên, bạn làm nóng lò ở nhiệt độ 200 độ C trong vòng 15 phút. Sau đó, cho bánh vào và nướng ở nhiệt độ 230 độ C trong 7 phút.
Nướng pizza bằng nồi chiên không dầu
Còn đối với nồi chiên không dầu, bạn nướng ở 200 độ C trong vòng 10 phút.
Thành phẩm
Lớp đế bánh giòn, phần gà cùng rau củ ngọt thơm hòa quyện với phô mai béo ngậy khiến bạn ăn hết miếng này lại ăn tiếp thêm miếng nữa.
Bạn có thể ăn kèm với tương cà và tương ớt để tăng thêm hương vị cho món ăn nhé!');
Insert into Recipe(rName, cID, Image, Difficulty, Time, uID, rDescription, Guideline1, Guideline2, Guideline3) values ('Vegetarian pizza','4','https://cdn.tgdd.vn/Files/2020/04/21/1250680/cach-lam-banh-pizza-chay-bang-noi-chien-khong-dau-10.jpg','Easy','60' ,'4',
'Pizza made with only weed',
'Sơ chế nguyên liệu
Cà chua mua về mang đi rửa sạch, cắt cà chua vắt nước cà chua ra riêng. Lột bỏ vỏ và cắt nhỏ cả chua ra.
Bắp ngọt đem rửa xạch, lảy lấy hột bắp.
Húng quế nhặt đi và rửa lại bằng nước sạch.
Hành tây rửa sạch, bỏ vỏ, dùng dao cắt thành những lát nhỏ.
Ớt ngọt rửa sạch, bỏ hạt và cắt thành sợi nhỏ. Ớt cay rửa sạch, bỏ cuống và cắt lát nhỏ.',
'Làm xốt cà chua
Đổ vào chảo 1 muỗng canh dầu ăn, bật lửa vừa đun nóng dầu. Khi dầu đã nóng bạn cho hành tây vào xào sơ.
Khi hành thơm bạn cho cà chua và nước cà chua vào xào.
Cà chua sắp chín thì nêm vào cà chua ít bột ngọt cho vừa ăn, khi cà chua sôi chín thì tắt bếp và để nguội.
Khi cà chua đã nguội thì bạn cho cà chua vào máy xanh sinh tố, xay cho cà chua nhuyễn mịn là được.
Thêm nhân cho bánh',
'Đặt đế pizza lên một bề mặt sạch, tiến hành phết dầu oliu quanh vành đế bánh.
Cho nước tương cà lên bánh và phết đều mặt bánh.
Rắc một ít phô mai bào, hành tây, bắp ngọt, ớt lên mặt bánh và một lớp phô mai dày ở lớp trên cùng là đã có thể nướng bánh.
Nướng bánh
Cho bánh vào nồi chiên không dầu, bật nồi ở 180 độ C và nướng bánh trong 7 phút. Sau 7 phút, bạn lấy bánh ra ngoài cắt bánh thành những miếng nhỏ là đã có thể dùng ngay.
Thành phẩm
Bánh pizza chay mới ra lò mang mùi thơm đặc trưng của phô mai, bánh xốp ngon, vị bánh beo béo hòa quyện với phần nước sốt cà chua đậm vị sẽ là bữa ăn sáng lý tưởng cho mọi gia đình. Bạn cũng có thể thêm xúc xích chay, chả chay, nấm để làm nhân cho bánh.');
Insert into Recipe(rName, cID, Image, Difficulty, Time, uID, rDescription, Guideline1, Guideline2, Guideline3) values ('Caesar salad with garlic butter bread','5','https://cdn.tgdd.vn/2021/11/CookRecipe/Avatar/salad-caesar-banh-mi-bo-toi-thumbnail.jpg','Easy','60' ,'4',
'Caesar salad made with a lot of vegetable and garlic butter bread',
'Băm nhuyễn tỏi và cá hộp
Bạn đập dập khoảng 6 tép tỏi, bóc bỏ vỏ rồi dùng dao băm nhuyễn tỏi ra. Trong lúc băm nhuyễn tỏi, bạn cho thêm khoảng 1/2 muỗng cà phê muối vào, trộn và băm nhuyễn cùng với tỏi.
Với cá hộp ngâm, bạn lọc bỏ xương và chắt bỏ phần nước, sau đó băm nhuyễn cá hộp. Trộn tỏi băm và cá hộp lại với nhau, băm nhuyễn thêm lần nữa cho hỗn hợp nhuyễn, mịn.
Mách bạn: Để hỗn hợp nhuyễn mịn hơn và tiết kiệm thời gian hơn bạn có thể cho vào máy xay sinh tố xay nhuyễn nhé.
Bước 1 Băm nhuyễn tỏi và cá hộp Salad caesar bánh mì bơ tỏi
Trộn sốt salad','
Bạn chuẩn bị một tô trộn, cho hỗn hợp tỏi và cá hộp đã băm nhuyễn vào tô, rồi cho tiếp 2 lòng đỏ, 1 muỗng canh mù tạt Dijon (khoảng 18gr), 1/2 muỗng cà phê muối và vắt khoảng 1/2 trái chanh. Sau đó dùng phới lồng đánh tan lòng đỏ và trộn đều hỗn hợp.
Bạn cho khoảng 300ml dầu thực vật vào trong bình xịt rồi vừa khuấy hỗn hợp nước sốt vừa cho từ từ dầu thực vật vào, tránh đổ một lần sẽ dễ làm hư hỗn hợp. Trộn đều đến khi hỗn hợp nhuyễn, mịn và chuyển sang màu vàng nhạt là được nhé.
Kế đến, cho khoảng 70gr phô mai parmesan (đã bào) vào trong tô sốt, trộn đều.
Bước 2 Trộn sốt salad Salad caesar bánh mì bơ tỏi
Trộn hỗn hợp bơ tỏi
Cho 200gr bơ lạt vào trong tô, dùng phới dẹt tán nhuyễn bơ ra. Sau đó băm nhuyễn 4 - 6 tép tỏi và một ít rau mùi tây cho vào trong tô đựng bơ, cho thêm 80gr phô mai parmesan vào cùng. Tiếp đến trộn đều hỗn hợp lại với nhau.
Bước 3 Trộn hỗn hợp bơ tỏi Salad caesar bánh mì bơ tỏi
Phết bơ và nướng bánh mì
Trước tiên, để nhiệt độ lò ổn định, bạn làm nóng lò nướng ở 160 độ C trong vòng 10 phút.
Kế đến, cắt đôi bánh mì thành 2 lát lớn, phết đều hỗn hợp bơ tỏi lên trên bánh mì.
Lót một lớp giấy bạc lên trên khay nướng rồi đặt bánh mì đã phết sốt lên khay cho vào lò, nướng bánh mì ở 205 độ C từ 10 - 12 phút.
Tiếp theo, bạn cắt bánh mì thành các thanh dài rồi cắt tiếp thành các miếng vuông nhỏ.',
'Bước 4 Phết bơ và nướng bánh mì Salad caesar bánh mì bơ tỏi
Trộn salad
Xà lách Roman mua về bạn chọn lấy lá non, bỏ lá sâu, úa. Sau đó cắt miếng vừa ăn rồi rửa sạch để ráo.
Cho rau xà lách vào trong tô, cho khoảng 1 nhúm nhỏ muối và một ít sốt salad vào, trộn đều cho rau thấm đều nước sốt nữa là có thể bày xà lách ra dĩa.
Bước 5 Trộn salad Salad caesar bánh mì bơ tỏi
Thành phẩm
Salad caesar bánh mì bơ tỏi với rau Roman giòn ngọt thấm đều nước sốt béo ngậy, mặn mặn, bánh mì giòn rụm với vị tỏi thơm nồng ăn kèm với rau càng thêm ngon, hấp dẫn. Bạn có thể cho thêm phô mai lên trên để tăng thêm vị béo cho món salad caesar nhé.
Bước 6 Thành phẩm Salad caesar bánh mì bơ tỏi');
Insert into Recipe(rName, cID, Image, Difficulty, Time, uID, rDescription, Guideline1, Guideline2, Guideline3) values ('Chicken breast caesar salad','6','https://cdn.tgdd.vn/2021/11/CookRecipe/Avatar/salad-caesar-uc-ga-thumbnail.jpg','Easy','45' ,'4',
'Chicken breast caesar salad made from chiken breast and caesar salad',
'Sơ chế và ướp ức gà
Để khử đi mùi hôi của ức gà sau khi mua về bạn có thể rửa với nước, rồi dùng muối chà xát xung quanh ức gà sau đó rửa lại với nước từ 2 - 3 lần rồi để ráo.
Ướp thịt gà với 1 muỗng cà phê muối và 1 muỗng cà phê tiêu và 20ml dầu oliu, thoa đều 2 mặt của thịt, cho thêm một vài lá rosemary và ướp trong vòng 10 - 15 phút để thịt thấm gia vị.
Làm bánh mì ăn kèm
Cắt bỏ 4 cạnh của miếng bánh sandwich, chỉ giữ lại phần ruột trắng. Sau đó, cắt miếng bánh mì thành các thành dài rồi cắt tiếp thành các miếng vuông nhỏ cho ra dĩa đựng.
Kế đến, cho khoảng 1 muỗng cà phê muối tiêu, rắc đều lên khắp bề mặt bánh mì và rưới thêm 20 - 30 ml dầu oliu, trộn đều.
Tiếp theo, cho bánh mì vào lò nướng ở nhiệt độ 150 độ C trong vòng 20 phút.',
'Bước 2 Làm bánh mì ăn kèm Salad caesar ức gà
Trộn sốt salad
Để làm sốt salad, đầu tiên bạn lột bỏ vỏ tỏi rồi cắt thành các lát mỏng và cắt nhỏ vỏ chanh cho vào máy xay sinh tố.
Kế đến cho lần lượt vào máy xay 1 muỗng canh mù tạt vàng, 1 hộp cá hộp anchovy, 50gr phô mai parmersan, 1/3 muỗng cà phê muối, 1/3 muỗng cà phê tiêu, cuối cùng vắt thêm khoảng 1/2 trái chanh vàng vào máy.
Sau đó, đậy nắp máy lại và xay nhuyễn hỗn hợp đến khi mịn. Đổ hỗn hợp ra tô, cho thêm 100gr sốt mayonnaise vào trộn đều tất cả lại với nhau.
Bước 3 Trộn sốt salad Salad caesar ức gà
Luộc trứng
Bắc nồi lên bếp, cho khoảng 500ml nước vào nồi, đun sôi ở lửa vừa. Khi nước bắt đầu sôi thì cho từ từ trứng gà vào và luộc từ 5 - 10 phút tùy thuộc vào độ chín của lòng đỏ mà bạn muốn.
Trứng sau khi chín lột bỏ vỏ và cắt ra làm tư.',
'Cách luộc trứng dễ bóc vỏ:
Khi luộc trứng cho thêm một ít giấm hoặc muối vào nồi nước vừa giúp trứng không bị vỡ trong quá trình luộc, vừa giúp bóc vỏ trứng ra dễ dàng hơn
Hoặc bạn cũng có thể cho một vài lát chanh vào nồi cũng giúp bóc vỏ nhanh hơn.
Ngoài ra, bạn cũng có thể tham khảo một số mẹo bóc vỏ trứng nhanh gọn từ Điện máy XANH nhé.
Bước 4 Luộc trứng Salad caesar ức gà
Áp chảo ức gà
Bắc chảo lên bếp, cho vào 2 muỗng canh dầu oliu, dầu nóng thì cho thịt gà vào và áp chảo mỗi mặt thịt khoảng 5 - 7 phút với lửa vừa đến khi gà chín, vàng đều thì gắp thịt gà ra dĩa.

Sau đó, đợi cho gà nguội bớt thì cắt thành các miếng nhỏ vừa ăn.

Bước 5 Áp chảo ức gà Salad caesar ức gà
Trộn salad
Giờ thì để hoàn thành món salad ngày hôm nay, bạn rửa sạch rau xà lách và cà chua bi, để ráo. Sau đó, cắt xà lách thành các khúc nhỏ, còn cà chua bi cắt đôi, cho tất cả ra tô cùng với 2 - 3 muỗng canh sốt salad, trộn đều.

Kế đến, xếp rau ra dĩa, rồi xếp lần lượt ức gà và trứng gà xen kẽ nhau, rắc bánh mì nướng xung quanh và rắc thêm một ít phô mai nữa là xong món ăn rồi đấy.');
Insert into Recipe(rName, cID, Image, Difficulty, Time, uID, rDescription, Guideline1, Guideline2, Guideline3) values ('Standard mashed potatoes','7','https://cdn.tgdd.vn/2020/07/CookProduct/easy-microwave-mashed-potatoes-3059678hero-01-520a91abceb44719ae5a24a179af8645-1200x676.jpg','Easy','60' ,'4',
'Usual mashed potatoes',
'Sơ chế khoai
Khoai tây sau khi mau về, bạn cần sơ chế bằng cách dùng nước lạnh và nhẹ nhàng chà vỏ ngoài củ khoai tây. Để đảm bảo khoai tây của bạn được làm sạch, bạn có thể sử dụng một bàn chải nhỏ để chà khoai tây.
Với cách này, các bụi bẩn bám bên ngoài lớp vỏ khoai tây sẽ được loại bỏ một cách tố nhất.
Tiếp đến, để hỗn hợp khoai tây nghiền được mịn hơn bạn cần bỏ lớp vỏ khoai tây trước khi mang đi luộc.',
'Luộc khoai tây
Đặt khoai tây đã được chuẩn bị xong vào một cái nồi lớn và đổ nước lạnh vào sao cho vừa ngập mặt khoai. Đợi đến khi nước sôi nổi bong bóng thì bạn hạ nhiệt bếp xuống và tiếp tục đun trong 10-20 phút cho khoai tây chín nhừ.
Bạn có thể kiểm tra khoai tây đã chín chưa bằng cách sử dụng một chiếc đũa hay một cái nĩa, sau đó cắm vào khoai tây. Nếu khoai rã ra khi bạn cắm một cái nĩa vào thì khoai tây của bạn đã chín. Để tăng thêm mùi vị cho khoai tây, bạn có thể cho vào 1 chút muối khi luộc.
Lưu ý: Không cho nước nóng vào từ lúc đầu và đậy nắp khi luộc, điều này sẽ khiến khoai tây của bạn chín không đều và gây sượn ở bên trong khoai.
Làm khoai tây nghiền',
'Sau khi khoai tây đã chín rồi, bạn lọc nước đổ đi, để lại khoai tây và bắt đầu nghiền. Để quá trình nghiền được dễ dàng hơn bạn hãy cho thêm bơ mềm vào trước khi nghiền nhé.
Bạn có thể sử dụng nĩa hay thìa để nghiền khoai tây. Để hỗn hợp được dẻo và ngọn hơn bạn hãy trộn chúng với sữa hoặc nước cốt gà đã đun nóng.
Mách bạn: Tuỳ loại khoai tây mà bạn kết hợp với lượng nguyên liệu khác nhau. Đừng cho quá nhiều sữa hay nước cốt gà nhé, nó sẽ khiến cho hỗn hợp khoai tây nghiền của bạn bị lỏng đấy!
Thành phẩm
Khoai tây nghiền có thể ăn kèm cùng những món như gà rán, gà nướng, soup … Để thưởng thức, bạn chỉ cần thêm chút muối, tiêu hoặc thêm bơ nếu bạn thích vị béo hơn một chút. Ăn khi nóng sẽ mang lại hương vị ngon nhất nên cố gắng dùng ngay khi vừa làm xong bạn nhé.');
Insert into Recipe(rName, cID, Image, Difficulty, Time, uID, rDescription, Guideline1, Guideline2, Guideline3) values ('Cheese baked potatoes','8','https://cdn.tgdd.vn/2020/07/CookRecipe/Avatar/khoai-tay-dut-lo-pho-mai-thumbnail.jpg','Easy',' 90' ,'4',
'Cheese baked with potatoes',
'Sơ chế nguyên liệu
Khoai tây sau khi mua về, rửa thật sạch. Dùng dao khía dọc thân khoai tây cho đến khi hết củ, chú ý không làm khoai đứt hẳn.
Sau khi thái xong, ngâm khoai vừa cắt trong nước muối khoảng 10 phút để khoai không bị thâm đen.
Mách bạn:
Để khoai tây sau khi nướng được giòn và thấm vị hơn, trong công đoạn sơ chế này bạn không cần gọt lớp vỏ ngoài của khoai đi.
Ngoài ra để cắt khoai tây không bị rời ra bạn hãy đặt khoai ở giữa 2 chiếc đũa.',
'Sơ chế các nguyên liệu khác
Cắt phô mai thành 6 miếng nhỏ vừa bằng khoanh khoai tây là được. Tỏi bỏ vỏ, rửa sạch, băm nhuyễn. Lá hương thảo cắt nhuyễn.
Tiếp đến, các bạn tiến hành băm nhỏ thịt xông khói nhé!
Cho bơ vào lò vi sóng quay ở chế độ rã đông khoảng 20 đến 25 giây cho bơ tan chảy hoàn toàn.
Quét bơ và nướng khoai tây
Sau khi bơ đã tan chảy hoàn toàn. Lấy bơ ra, cho vào chén bơ thêm 1/2 muỗng cà phê muối và 1/2 muỗng cà phê tiêu xay, sau đó khuấy đều để món ăn thêm đậm đà vào bạn nhé!
Tiếp đến, phết bơ lên từng lát của khoai tây, chú ý phủ đều mặt khoai bạn nhé!',
'Sau đó, cho khoai vào lò và nướng ở 200 độ C trong vòng 1 giờ đồng hồ đến khi vỏ khoai tây giòn và bên trong khoai chín mềm là được.
Chiên thịt xông khói
Trong thời gian chờ khoai tây chín, bắc chảo lên bếp, cho dầu vào và chiên thịt xông khói cho vàng và giòn. Đặt thịt xông khói vừa chiên lên giấy thấm dầu để loại bỏ bớt lượng mỡ thừa.
Làm khoai tây đút lò
Khoai sau khi đã nướng xong, các bạn mang ra khỏi lò, để khoai bớt nóng khoảng 3 phút, sau đó tiếp tục cho phô mai vào giữa các lát khoai bạn nhé. Cắt sợi lượng phô mai còn lại và rắc lên bề mặt khoai tây.
Sau đó, cho khoai trở lại vào lò nướng trong vòng 5 phút với nhiệt độ cũ để phô mai được tan chảy hết.
Hoàn thành
Lấy khoai ra khỏi lò nướng. Rưới kem chua hoặc sữa chua và lá hương thảo băm nhuyễn lên trên khoai tây. Tiếp tục rắc thịt xông khói lên. Vậy là món ăn của bạn đã hoàn thành rồi đó!');
Insert into Recipe(rName, cID, Image, Difficulty, Time, uID, rDescription, Guideline1, Guideline2, Guideline3) values ('Simple Baked Potatoes','9','https://cdn.tgdd.vn/2020/11/CookRecipe/Avatar/khoai-tay-dut-lo-thumbnail.jpg','Easy','30' ,'1',
'Simple potatoes which is baked',
'Sơ chế khoai tây
Khoai tây mua về bạn ngâm với nước muối loãng 15 phút rồi rửa sạch lại với nước, đồng thời dùng bàn chải chà sạch hết đất cát bám trên vỏ khoai tây.
Cắt khoai tây thành từng lát mỏng không cắt rời, chừa lại 1cm ở dưới.
Mách bạn: Để không cắt rời bạn có thể dùng đũa ép 2 bên dưới để cắt khoai tây.',
'Làm sốt phết khoai
Bạn bắc chảo lên bếp mở lửa vừa, đợi chảo nóng bạn cho bơ, dầu ô liu, tỏi bóc vỏ đập dập, 3 nhánh cỏ xạ hương, bạn nấu khoảng 3 - 4 phút cho đến khi bơ chảy và tỏi ngả vàng thì tắt bếp lọc qua rây.
Phết sốt lên khoai tây
Bạn quết đều sốt bơ lên xung quanh khoai tây, rắc thêm 1 ít muối và tiêu.
Đút lò khoai tây',
'Bạn bật lò trước 10 phút ở nhiệt độ 200 độ C để nhiệt độ trong lò ổn định.
Nướng lần 1: Bạn cho khoai vào nướng trong 30 phút ở nhiệt độ 200 độ C.
Tiếp đó bạn lấy khay ra khỏi lò, rắc 1 nhánh cỏ xạ hương vò nát (hoặc loại thảo mộc khác tùy ý thích). Quết đều 1 lớp sốt bơ lên khoai.
Nướng lần 2: Bạn cho khoai vào nướng tiếp 30 phút ở nhiệt độ 200 độ C, cho đến khi khoai tây giòn ở các cạnh.
Thành phẩm
Vậy là món khoai tây đút lò thơm phức đã hoàn thành rồi, khoai tây với lớp vỏ ngoài giòn giòn, bên trong mềm thơm với vị bùi bùi, béo béo kèm vị thơm đặc trưng của cỏ xạ hương, chắc chắn sẽ làm hài lòng những thực khách khó tính, thưởng thức thôi nào.');
Insert into Recipe(rName, cID, Image, Difficulty, Time, uID, rDescription, Guideline1, Guideline2, Guideline3) values ('Cheese Beef Hamburger','10','https://cdn.tgdd.vn/Files/2017/07/03/999119/cach-lam-hamburger-bo-pho-mai-sieu-don-gian-tai-nha.jpg','Easy','40 ' ,'4',
'Hamburger made from beef mix with cheese',
'Ướp thịt bò
rộn đều thịt bò băm với các loại gia vị gồm 2 muỗng cà phê đường, 3 muỗng cà phê hạt nêm, 1/2 muỗng cà phê muối, 1/2 chén bột chiên xù và 1 muỗng canh dầu ăn. Sau đó, ướp trong vòng 15 phút.',
'Vo thịt thành từng viên tròn, đem chiên chín. Khi chiên ấn cho viên thịt tròn dẹt xuống. Có thể cho phô mai bào sợi lên nếu thích.
Hoàn thành',
'Cắt đôi bánh mì rồi phết tương ớt, mayonnaise, lần lượt cho rau xà lách, cà chua, phô mai, thịt bò đã chiên lên, úp nửa miếng bánh mì còn lại lên vậy là hoàn thành rồi.
Thành phẩm
Lớp vỏ bánh mì giòn, thịt bò được nêm nếm vừa phải ăn kèm với phần phô mai beo béo, thêm chút cà chua và xà lách cân bằng lại hương vị, khiến món ăn không hề ngán tí nào mà lại còn thơm ngon, hấp dẫn');
Insert into Recipe(rName, cID, Image, Difficulty, Time, uID, rDescription, Guideline1, Guideline2, Guideline3) values ('French Beef Stew with Vegetables','11','https://cdn.tgdd.vn/2021/05/CookProduct/3-1200x676.jpg','Easy','60' ,'4',
'Stew made from Beef and vegetables with French style',
'Sơ chế thịt bò
Thịt bò mua về rửa sạch, cho vào rổ để cho ráo bớt nước rồi dùng dao cắt thành từng miếng vuông nhỏ vừa ăn.
Cách sơ chế thịt bò đúng cách
Thịt bò nên được cắt ngang thớ thịt để thịt được mềm và ngon hơn.
Bạn có thể đặt thịt trong tủ lạnh khoảng 15 - 20 phút trước khi cắt, giúp thịt định hình, dễ dàng nhìn thấy thớ thịt khi cắt.
Thịt bò mua về tránh ngâm và rửa quá lâu trong nước, khiến chất ngọt trong thịt bị giảm sút, ảnh hưởng hương vị thịt.
Miếng thịt sau khi mua về bạn nên dùng khăn ẩm thấm bớt nước trên bề mặt thịt, dùng gừng đã được nướng sơ qua, giã nhuyễn rồi chà xát thật đều miếng thịt.
Rửa lại với nước giúp khử mùi hôi một cách hiệu quả.',
'Xem chi tiết: Cách sơ chế thịt bò đúng cách
Sơ chế các nguyên liệu khác
Cà rốt, hành tây, khoai tây sau khi mua về gọt sạch vỏ, rửa sạch. Dùng dao cắt thành miếng vuông nhỏ vừa ăn.
Cần tây rửa sạch, cắt thành từng đoạn dài khoảng 2 - 3 đốt ngón tay là được. Lá húng tây rửa sạch để ráo nước.
Nấm linh chi trắng rửa nhẹ nhàng với nước sạch, tách rời từng tai nấm nhỏ, chờ ráo bớt nước.
Ướp thịt bò
Ướp thịt với 1 muỗng canh hạt nêm, 1 ít tiêu xay, dùng đũa trộn đều thịt trong tô, để yên trong khoảng 15 phút, giúp thịt thấm đều gia vị.
Hầm thịt bò',
'Bắc lên bếp 1 cái chảo đun nóng 2 muỗng canh dầu ăn, cho thịt bò vào xào săn với lửa lớn vừa. Đến khi thấy thịt chuyển màu sang tái dần, mặt thịt săn lại thì thêm vào 4 muỗng canh sốt cà chua, 3 muỗng canh dầu hào, trộn đều.
Thêm nước vào chảo sao cho nước vừa sấp mặt thịt, nêm với 1 muỗng cà phê đường, 1/2 muỗng cà phê muối, khuấy nhẹ nhàng giúp gia vị hòa tan nhanh hơn. Chỉnh lửa nhỏ hơn, đậy nắp và hầm thịt trong khoảng 40 phút.
Xào rau củ
Bắc lên bếp 1 cái chảo khác, cho vào 2 muỗng canh dầu ăn. Khi dầu nóng cho hết cà rốt, khoai tây, hành tây và rau cần tây vào xào đều tay với lửa lớn trong khoảng 1 - 2 phút.
Tiếp tục cho hết nấm linh chi trắng, 1 muỗng canh bơ lạt vào xào đều thêm khoảng 2 phút thì nhanh tay tắt bếp.
Hầm bò với rau củ
Khi thịt bò đã chín đều cho hết rau củ đã được xào sơ vào chảo, thêm khoảng 6 muỗng canh rượu vang đỏ, thêm 3 lá húng tây vào chung, đậy nắp và tiếp tục nấu thêm khoảng 5 - 10 phút, nêm nếm lại cho vừa ăn là có thể tắt bếp.
Mách bạn: Khi cho tất cả nguyên liệu vào chảo, bạn có thể lót thêm một miếng giấy nến dưới nắp chảo, rồi đậy kín. Giúp thịt nhanh mềm hơn rất nhiều.
Thành phẩm
Cho thịt bò hầm rau củ ra đĩa và thưởng thức cùng gia đình thôi nào! Món ăn mang màu sắc nâu bóng mượt, xen lẫn với màu sắc nổi bật từ cà rốt, hành tây, rau cần,... thêm hương vị thơm nồng cuốn hút từ thịt bò mềm ngon cùng lá húng tây bắt vị.
Hương vị đậm đà, mặn ngọt vừa phải, xen lẫn chút vị cay nhẹ từ tiêu xay giúp món ăn trở nên hấp dẫn hơn bao giờ hết.
Ăn kèm với cơm trắng, bánh mì hoặc bún tươi đều được nhé!');
Insert into Recipe(rName, cID, Image, Difficulty, Time, uID, rDescription, Guideline1, Guideline2, Guideline3) values ('Spaghetti with Minced Beef Tomato Sauce','12','https://cdn.tgdd.vn/2021/11/CookRecipe/Avatar/mi-y-sot-ca-chua-bo-bam-cong-thuc-duoc-chia-se-tu-nguoi-dung-thumbnail.jpg','Easy','30' ,'4',
'Spaghetti made from Minced Beef with tomato sauce',
'Luộc mì
Bắc nồi lên bếp, cho khoảng 700ml nước vào nấu với lửa lớn. Đến khi nước sôi lên thì cho 1 muỗng cà phê muối và hết 200gr mì ý vào, giảm lại lửa vừa, khi đầu mì chạm nước đã mềm thì dùng tay nhấn hết toàn bộ sợi mì chìm xuống nước.
Khuấy đều mì và nấu khoảng 8 - 10 phút thì tắt bếp, rồi vớt mì đã luộc ra rổ cho ráo nước là hoàn thành.',
'Ướp thịt
Cho 200gr thịt bò bằm vào 1 cái tô, cho vào 1/2 muỗng cà phê muối và 1/3 muỗng cà phê tiêu xay rồi trộn đều. Sau đó đem đi ướp khoảng 10 phút cho thịt bò thấm gia vị.
Làm sốt mì ý',
'Đặt chảo lên bếp bật lửa vừa, cho vào 1 muỗng canh dầu ô liu, chờ dầu nóng thì cho tiếp 1/2 củ hành tây cắt hạt lựu vào phi thơm.
Tiếp đó cho thịt bò bằm đã ướp gia vị vào xào thật đều tay để bò không bị dính lại với nhau. Bạn xào khoảng 3 phút cho thịt bò chín nhé.
Sau khi thịt bò đã chín bạn cho hết 400gr sốt mì ý đã làm sẵn vào chảo thịt xào rồi đảo đều tay khoảng 3 phút, thêm 1/3 muỗng cà phê tiêu xay vào đảo đều rồi tắt bếp.
Hoàn thành
Bạn cho mì ý đã luộc ra dĩa sau đó rưới 1 ít sốt bò bằm lên trên, thêm 1 trái cà chua được cắt tỉa thành hình hoa đẹp mắt lên trên để trang trí là hoàn thành.');

Insert into Recipe_ingredient(rID, inID) values ('1','1');
Insert into Recipe_ingredient(rID, inID) values ('1','2');
Insert into Recipe_ingredient(rID, inID) values ('1','3');
Insert into Recipe_ingredient(rID, inID) values ('1','4');
Insert into Recipe_ingredient(rID, inID) values ('1','5');
Insert into Recipe_ingredient(rID, inID) values ('1','6');
Insert into Recipe_ingredient(rID, inID) values ('1','10');
Insert into Recipe_ingredient(rID, inID) values ('1','11');

Insert into Recipe_ingredient(rID, inID) values ('2','1');
Insert into Recipe_ingredient(rID, inID) values ('2','2');
Insert into Recipe_ingredient(rID, inID) values ('2','3');
Insert into Recipe_ingredient(rID, inID) values ('2','7');
Insert into Recipe_ingredient(rID, inID) values ('2','8');
Insert into Recipe_ingredient(rID, inID) values ('2','9');
Insert into Recipe_ingredient(rID, inID) values ('2','12');
Insert into Recipe_ingredient(rID, inID) values ('2','13');

Insert into Recipe_ingredient(rID, inID) values ('3','1');
Insert into Recipe_ingredient(rID, inID) values ('3','14');
Insert into Recipe_ingredient(rID, inID) values ('3','15');
Insert into Recipe_ingredient(rID, inID) values ('3','16');
Insert into Recipe_ingredient(rID, inID) values ('3','17');
Insert into Recipe_ingredient(rID, inID) values ('3','18');
Insert into Recipe_ingredient(rID, inID) values ('3','2');
Insert into Recipe_ingredient(rID, inID) values ('3','5');
Insert into Recipe_ingredient(rID, inID) values ('3','3');
Insert into Recipe_ingredient(rID, inID) values ('3','6');

Insert into Recipe_ingredient(rID, inID) values ('4','1');
Insert into Recipe_ingredient(rID, inID) values ('4','19');
Insert into Recipe_ingredient(rID, inID) values ('4','9');
Insert into Recipe_ingredient(rID, inID) values ('4','21');
Insert into Recipe_ingredient(rID, inID) values ('4','2');
Insert into Recipe_ingredient(rID, inID) values ('4','3');
Insert into Recipe_ingredient(rID, inID) values ('4','20');

Insert into Recipe_ingredient(rID, inID) values ('5','22');
Insert into Recipe_ingredient(rID, inID) values ('5','23');
Insert into Recipe_ingredient(rID, inID) values ('5','24');
Insert into Recipe_ingredient(rID, inID) values ('5','25');
Insert into Recipe_ingredient(rID, inID) values ('5','26');
Insert into Recipe_ingredient(rID, inID) values ('5','27');
Insert into Recipe_ingredient(rID, inID) values ('5','28');
Insert into Recipe_ingredient(rID, inID) values ('5','29');
Insert into Recipe_ingredient(rID, inID) values ('5','30');
Insert into Recipe_ingredient(rID, inID) values ('5','31');

Insert into Recipe_ingredient(rID, inID) values ('6','32');
Insert into Recipe_ingredient(rID, inID) values ('6','33');
Insert into Recipe_ingredient(rID, inID) values ('6','34');
Insert into Recipe_ingredient(rID, inID) values ('6','35');

Insert into Recipe_ingredient(rID, inID) values ('7','36');
Insert into Recipe_ingredient(rID, inID) values ('7','37');
Insert into Recipe_ingredient(rID, inID) values ('7','38');
Insert into Recipe_ingredient(rID, inID) values ('7','39');
Insert into Recipe_ingredient(rID, inID) values ('7','40');
Insert into Recipe_ingredient(rID, inID) values ('7','41');
Insert into Recipe_ingredient(rID, inID) values ('7','42');

Insert into Recipe_ingredient(rID, inID) values ('8','43');

Insert into Recipe_ingredient(rID, inID) values ('9','44');

Insert into Recipe_ingredient(rID, inID) values ('10','45');
Insert into Recipe_ingredient(rID, inID) values ('10','46');
Insert into Recipe_ingredient(rID, inID) values ('10','47');
Insert into Recipe_ingredient(rID, inID) values ('10','48');

Insert into Recipe_ingredient(rID, inID) values ('11','7');
Insert into Recipe_ingredient(rID, inID) values ('11','45');

Insert into Recipe_ingredient(rID, inID) values ('12','49');
Insert into Recipe_ingredient(rID, inID) values ('12','50');

