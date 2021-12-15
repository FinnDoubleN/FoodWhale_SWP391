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

CREATE TABLE CategoryRecipe(
	categoryID int NOT NULL auto_increment,
	cName varchar (30) NOT NULL,
    Description varchar(225) NOT NULL,
    Status varchar(20) NULL default 'Active',
    primary key (categoryID)
    );
ALTER TABLE CategoryRecipe AUTO_INCREMENT=1;

CREATE TABLE CategoryIngredient(
	categoryID int NOT NULL auto_increment,
	cName varchar (30) NOT NULL,
    Description varchar(225) NOT NULL,
    Status varchar(20) NULL default 'Active',
    primary key (categoryID)
    );
ALTER TABLE CategoryIngredient AUTO_INCREMENT=1;

CREATE TABLE Ingredient(
	inID int NOT NULL auto_increment,
	inName varchar(100) NOT NULL,
	Image varchar(255) NOT NULL,
	Type varchar(30) NOT NULL,
	Price double NOT NULL,
	categoryID int NOT NULL,
	description varchar(100) NULL,
    guideline varchar(255) NULL,
    Status varchar(20) NULL default 'Active',
    primary key (inID),
    foreign key (categoryID) references CategoryIngredient(categoryID)
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
    Status varchar(20) NULL default 'Active',
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
	Guideline text(65535) NULL,
    Status varchar(20) NULL default 'Active',
    primary key (rID),
    foreign key (cID) references CategoryRecipe(categoryID),
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

Insert into CategoryRecipe(cName, Description) values ('Pizza Recipes', 'Recipe for Pizza type');
Insert into CategoryRecipe(cName, Description) values ('Salad Recipes', 'Recipe for Salad type');
Insert into CategoryRecipe(cName, Description) values ('Potatoes Recipes', 'Recipe for Potatoes type');
Insert into CategoryRecipe(cName, Description) values ('Hamburger', 'Recipe for Hamburger type');
Insert into CategoryRecipe(cName, Description) values ('Main dish', 'Recipe for Main Dish type');
Insert into CategoryRecipe(cName, Description) values ('Spaghetti', 'Recipe for Spaghetti type');

Insert into CategoryIngredient(cName, Description) values ('Seasoning', 'Ingredient for Seasoning type');
Insert into CategoryIngredient(cName, Description) values ('Vegetable', 'Ingredient for Vegetable type');
Insert into CategoryIngredient(cName, Description) values ('Cheese', 'Ingredient for Cheese type');
Insert into CategoryIngredient(cName, Description) values ('SeaFood', 'Ingredient for SeaFood type');
Insert into CategoryIngredient(cName, Description) values ('Meat', 'Ingredient for Meat type');
Insert into CategoryIngredient(cName, Description) values ('Oil', 'Ingredient for Oil type');
Insert into CategoryIngredient(cName, Description) values ('Dough', 'Ingredient for Dough type');

Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values('Pizza Base','https://i.ytimg.com/vi/sLfp4T1dxhU/maxresdefault.jpg','20Cm' , '5','6' ,'Pizza Base for Pizza','Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Onion','https://dictionary.cambridge.org/vi/images/thumb/onion_noun_001_11239.jpg?version=5.0.199','500g' , '1','2' ,'Onion' ,'Preserved in dry, cool place');
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Bell Pepper','https://hosstools.com/wp-content/uploads/2020/10/mini-belle-pepper-mix.jpg','500g' , '5','2' ,'Bell pepper' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Butter','https://cdn.tgdd.vn/2020/07/CookProduct/cach-lam-bo-butter-bang-kem-tuoi-heavy-cream-1-1200x676.jpg','500g' , '5','6' ,'Butter' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Mozzarella Cheese','https://santorino.org/wp-content/uploads/2020/11/pho-mai-bao-mozzarella-uruguay.jpg','500g' , '10','3' ,'Mozzarella' ,'Store in a cool, dry place away from direct sunlight' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Tomato Sauce','https://salt.tikicdn.com/ts/product/2e/d2/f1/ff2fd0f01c5c89ce6a5faead91d65032.png','500ml' , '4','1' ,'Tomato Sauce' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Beef','https://hanoismallgoods.com/wp-content/uploads/2021/05/beef-cheek-2.jpg','1kg' , '15','5' ,'US Beef' ,'Store in a cool, dry place away from direct sunlight' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('PineApple','https://vcdn-vnexpress.vnecdn.net/2017/03/09/pineapple-1268-1489051642.jpg','500g' , '2','2' ,'Pineapple' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Sweet Corn','http://bizweb.dktcdn.net/thumb/grande/100/408/264/products/5116776ngo-ngot-sweet-corn-000000002462-jpeg.jpg?v=1603792320133','1kg' , '5','2' ,'Sweetcorn' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Squid','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQcVSqoV9gOlFlOrVaT11Q5yAad4qPl9OBI-g&usqp=CAU','500g' , '10','4' ,'Squid' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Shrimp','https://solidstarts.com/wp-content/uploads/Shrimp-for-Babies-scaled.jpg','500g' , '8','4' ,'Shrimp' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Minced garlic','https://vn-test-11.slatic.net/p/c4a542e2652df3bc2068f7bc70217a46.jpg','100g' , '2','1' ,'Mirnced' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Oregano','https://lh3.googleusercontent.com/proxy/2w2I6mfMTo6dXqNEzVQFeRjqVr735yDJmGpv-U0WewahkFYsq8DpFlNvA_PJolaqAO9freYjKYsj46yyK3OclRaAP0aG2AybqxEh9gE3CMprcKYgQHFHhb-wdVBnxlE3jH-X0rbvuRRpser4iw','100g' , '3','1' ,'Oregano dry leaves' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Chicken breast','https://www.foodiecrush.com/wp-content/uploads/2018/08/Instant-Pot-Chicken-Breasts-foodiecrush.com-006A.jpg','500g' , '8','5' ,'Ức gà ta' ,'Bảo quản ngăn mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Sausage','https://i0.wp.com/hanoismallgoods.com/wp-content/uploads/2021/04/spiced-lamb-sausage.jpg','500g' , '4','5' ,'Xúc xích Đức Việt' ,'Bảo quản ngăn mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Salt','https://media.istockphoto.com/photos/crystals-of-shallow-salt-in-a-scoop-spoon-on-a-dark-gray-table-for-picture-id1051727580?k=20&m=1051727580&s=612x612&w=0&h=v3gWwwVtHrz6fNouAUAydniYE9SedKbORry0cE-Kzq0=','1kg' , '1','1' ,'Salt' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Sugar','https://1.bp.blogspot.com/-vg93ooJdZr8/XhYcsMiWbtI/AAAAAAAAB8k/jO-UA3qtanU4_jj5Va_UQth5PD6WjJtGgCLcBGAsYHQ/s640/sugar-la-gi.jpg','1kg' , '1','1' ,'Sugar ' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Seasoning seeds','https://www.sonnentor.com/at/product-images/00323/image-thumb__65732__thumb-slider/brotgeweurz_ganz_WEBSITE.jpeg','500g' , '3','1' ,'Seasoning' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Olive oil','https://lh3.googleusercontent.com/proxy/gmIbXf-LQQM_HhnglP_C9Xa-jBNW6M0Nv5rO0BIO2Dbaa1c1VrxaghuE7BFfR7iyOtKFzT_5QHBM20t-QK0NPqAO9IBfwgr0pg1nQ2V_nynHMh9TjJ-soLtRhsftq64','500ml' , '20','6' ,' olive Oil' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Grated Cheese','https://produits.bienmanger.com/38243-0w470h470_Badoz_Grated_Cheese_For_Cheese_Fondue.jpg','1kg' , '15','3' ,'Grated cheese' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Basil','https://cdn.daylambanh.edu.vn/wp-content/uploads/2019/06/basil-la-gi.jpg','200g' , '4','1' ,'Basil' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Roman Lettuce','https://cdn.shopify.com/s/files/1/0509/8173/2535/products/moreecoliill.jpg?v=1629176803','100g' , '1','2' ,'Roman lettuce' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Bread','https://upload.wikimedia.org/wikipedia/commons/0/0f/Serbian_bread.jpg','100g' , '1','7' ,'Bread' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Canned Fish','https://sc04.alicdn.com/kf/U32d895585ee94989a3a234e127ca0094X.jpg','300g' , '6','4' ,'Canned Fish' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Unsalted Butter','https://product.hstatic.net/1000282430/product/unsalted-butter-anchor-227g_2ae3edfcc7d4481f8db2bb1c52fd04f7_large.jpg','500g' , '15','6' ,'Unsalt Butter' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Dijon Mustard','https://m.media-amazon.com/images/I/41bUsaQvGGL.jpg','50g' , '5','1' ,'dijon mustard' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Chicken Egg','https://www.australianeggs.org.au/assets/tiles/How-chickens-make-eggs__FocusFillWyIwLjAwIiwiMC4wMCIsMTIwMCw2Mjhd.jpg','1 quả' , '1','5' ,'Eggs' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Lemon','https://upload.wikimedia.org/wikipedia/commons/thumb/e/e4/Lemon.jpg/1024px-Lemon.jpg','1 quả' , '1','2' ,'Lemon' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Garlic','http://nasol.com.vn/Uploads/images/tin%20t%E1%BB%A9c/TIN%20TUC/chiet-xuat-toi.jpg','100g' , '6','2' ,'Garlic' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Parmesan Cheese','https://cdn.cet.edu.vn/wp-content/uploads/2019/04/parmesan-la-gi.jpg','500g' , '20','3' ,' Parmesan Cheese' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Vegetable Oil','https://i5.walmartimages.com/asr/e619efe0-990c-473e-bcc0-f2ba4da78252.60998c9abf70659a317eb43697bc39da.jpeg','500ml' , '25','6' ,'Vegetable oil' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Sanwich','https://cdn.tgdd.vn/2020/11/CookRecipe/GalleryStep/thanh-pham-432.jpg','1 cái' , '1','7' ,' sanwich' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Rosemary','https://trankinhan.com/wp-content/uploads/2019/08/Tim-hieu-ve-cay-huong-thao-Rosemary-1.jpg','200g' , '6','2' ,'Rosemary' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Yellow mustard','https://produits.bienmanger.com/27673-0w600h600_French_Classic_Yellow_Mustard.jpg','50g' , '6','1' ,'Yellow Mustard' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Canned Fish anchovy','https://m.media-amazon.com/images/I/61odrkS7Q0L._SL1000_.jpg','300g' , '7','4' ,'Anchovy Canned Fish' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Potatoes','https://sc04.alicdn.com/kf/Ub6c21d80565841e99c7fbf2bfa776fc2a.jpg','500g' , '8','2' ,'Potato' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Milk','https://cdn.tgdd.vn/Products/Images/2386/92114/bhx/thung-12-hop-sua-tuoi-tiet-trung-th-true-milk-nguyen-chat-hop-1-lit-201903131359109964.jpg','500ml' , '4','3' ,'Milk' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Peper','https://5.imimg.com/data5/VL/QI/EM/ANDROID-38962981/1564424969436-jpg-500x500.jpg','100g' , '3','2' ,'Pepper' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Bacon','https://www.hoidaubepaau.com/wp-content/uploads/2018/11/thit-nac.jpg','500g' , '15','5' ,'Bacon' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Cheese Sliced','https://cf.shopee.vn/file/541c546235dd604d0c0ec30781f1e4df','500g' , '9','3' ,'Slide Cheese' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Salted butter','https://product.hstatic.net/1000282430/product/salted-butter-anchor-250g_1e0aecc0c4cd460aa98ebcd9fc69132c_large.jpg','500g' , '11','6' ,'Salted butter' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Yogurt','https://cdn.dayphache.edu.vn/wp-content/uploads/2021/03/greek-yogurt.jpg','1 hộp' , '1','6' ,'Greek yogurt' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Thyme ','https://lh3.googleusercontent.com/proxy/aOonpXmErujR7PvKOeTZ26wN5611mOMjYCwsnYLipcKPArgU_jE_DQgczAKkmZc6Bmvr6DxRpNQTTqcgSaC3nRinjul9-GeeHJnv1sDTJS6qNn_rudQAr4RDd2Ouq0Tvfc7Y22b3J5fbi-tbAROYRATn','100g' , '4','1' ,'Thyme' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Dough','https://3f4c2184e060ce99111b-f8c0985c8cb63a71df5cb7fd729edcab.ssl.cf2.rackcdn.com/media/16863/all-purposebreaddough.jpg','2 cái' , '3','7' ,'Dough' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Carrots','https://luxuryfoods.vn/wp-content/uploads/2020/12/unnamed-1-1.jpg','500g' , '6','2' ,'Cà rốt' ,'Bảo quản nơi khô ráo thoáng mát' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('White reishi mushroom','https://thumbs.dreamstime.com/z/fresh-white-beech-mushroom-white-reishi-mushroom-plate-white-beech-mushroom-white-reishi-mushroom-233039121.jpg','500g' , '16','2' ,'White Reishii Mushroom' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Oyster Oil','https://dl.airtable.com/.attachments/7bd18b26b0acf4ef45f2427e8c475392/496e273e/IMG_1928.jpg-large2x.jpg','500ml' , '25','6' ,' Oyster oil' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Red wine','https://winevn.com/wp-content/uploads/2021/06/Ruou-Vang-Coppola-Eleanor-Red-Wine.jpg','500ml' , '40','6' ,'Red wine' ,'Preserved in dry, cool place' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Spaghetti','https://www.collinsdictionary.com/images/full/spaghetti_175767539.jpg','500g' , '10','7' ,'Spaghetti' ,'Preserved in dry, cool placet' );
Insert into Ingredient(inName, Image, Type, Price, categoryID, Description, Guideline) values ('Spaghetti Sauce','https://iheartvegetables.com/wp-content/uploads/2021/05/Meatless-Spaghetti-Sauce-20-of-25.jpg','500g' , '20','1' ,'Spaghetti sauce' ,'Preserved in dry, cool place' );

Insert into Recipe(rName, cID, Image, Difficulty, Time, uID, rDescription, Guideline) values ('Pizza SeaFood','1','https://cdn.tgdd.vn/2020/09/CookRecipe/Avatar/pizza-hai-san-pho-mai-thumbnail.jpg','Easy','90','4',
'Pizza made from sea food',
'Prepare and marinate seafood:
Shrimp you peel off the shell, remove all the head and tail, use a knife to make a slit on the back of the shrimp to easily remove all the shrimp.
Buy squid to peel off the outer skin, wash and cut into circles.
Add in the shrimp and squid 1/2 teaspoon salt, 1/2 teaspoon sugar, 1/2 teaspoon pepper and 1 teaspoon seasoning. Mix well and let stand for about 10 minutes.
Preparing other ingredients:
Buy bell peppers, wash, cut into small squares about 1-2 fingers. Sliced ​​purple onion in circles. Thinly slice chili, remove all seeds.
Stir-fry seafood:
Put on the stove 1 pan, wait until hot, saute onion and minced garlic. Put all the seafood in and stir-fry on high heat until you can turn off the stove.
Put the filling on the cake base
Spread a layer of ketchup evenly on the pizza base, arrange all the purple onions, bell peppers, and cheese on top of the cake.
Add seafood and a few slices of chili on top and prepare to bake, can add another layer of cheese on top if you like. Bake:
Method 1: Bake pizza in the oven
First, you need to open the oven first to preheat it, open it at 200 degrees Celsius for 10-15 minutes. When there is enough time for the cake to bake at 230 degrees Celsius for about 7 minutes.
Method 2: Bake pizza in an oil-free fryer
For the air fryer, before baking, preheat the oven for 5 minutes at 180 degrees, then bake the pizza at 200 degrees for 10 minutes.
Finished products:
The hot, crispy pizza comes out of the oven with seafood mixed in a layer of greasy cheese served with bell peppers, making it even more attractive.
Save the recipe now and go to the kitchen to show off your talents for the whole family to enjoy!');

Insert into Recipe(rName, cID, Image, Difficulty, Time, uID, rDescription, Guideline) values ('Pineapple beef pizza','1','https://cdn.tgdd.vn/2020/08/CookRecipe/Avatar/pizza-bo%CC%80-du%CC%81a-thumbnail.jpg','Easy','60' ,'4',
'Pizza made with Pineapple and beef',
'Process materials
Wash the beef and mince it finely. Peel sweet corn, clean the antennae and separate into seeds or use a knife. Peeled garlic, minced
Onion peeled, washed, part you cut the string to taste, part you minced. Wash the bell peppers, remove the seeds and cut them. Peel pineapple, cut eyes, wash and cut into triangles.
Fried stuffing:
You put the oil in the pan, when the oil is hot, add minced garlic, minced onion and oregano and fry until fragrant. When the ingredients are golden, add the beef and stir-fry with 2 tablespoons of tomato sauce.
Then, you add the sweet corn with 1 tablespoon of sugar, half a teaspoon of salt and stir well.
Put the filling on the cake base
To make the crust more crispy, bake the cake base at 180 degrees for 3 minutes in an air fryer.
After 3 minutes, you take out the cake and spread the ketchup evenly, cheese on top, followed by beef sauce, pineapple, onion, bell pepper and finally another layer of cheese.
Bake pizza.
Option 1: Bake pizza in an oil-free fryer
You bake in an oil-free fryer at 200 degrees Celsius for 10 minutes
Method 2: Bake pizza in the oven
Preheat oven for 10 minutes at 200 degrees Celsius before baking. You bake in the oven at 200 degrees Celsius for 10 minutes for crispy crust, 7 minutes for soft cake.
Finished product
The hot pineapple beef pizza has come out of the oven, the pizza is crispy and soft, the beef is fragrant, the corn is sweet and the vegetables are fresh, making everyone smile. The cake will be even more delicious when you eat it with that chili sauce or mayonnaise.');

Insert into Recipe(rName, cID, Image, Difficulty, Time, uID, rDescription, Guideline) values ('Cheese chicken pizza','1','https://cdn.tgdd.vn/2020/09/CookRecipe/GalleryStep/tha%CC%80nh-pha%CC%89m-8.jpg','Easy','60' ,'4',
'Pizza made with Cheese and chicken',
'Preliminary processing of vegetables
Wash bell peppers, use the tip of a knife to separate the stalks, then cut the peppers into slices. Red onion peeled and sliced. Sliced ​​sausage.
Preliminary processing of chicken
Chicken breast you wash, drain, cut into medium pieces and marinate with 5g salt, 5g seasoning, 5g pepper, 2g sugar, then mix well and marinate the chicken for 15 minutes.
Fry and shred chicken.
Put 50ml of oil into the pan, when the oil is hot, add the chicken and fry until soft. When the chicken is cooked, tear the chicken into thin slices.
Put the filling on the cake base
First, you put ketchup on top and spread evenly. Next, you alternate bell peppers, red onions, then shredded chicken, sausages and finally Mozzarella cheese.
Bake. 
Baking pizza in the oven
When you use the oven to bake a cake, you first preheat the oven to 200 degrees Celsius for 15 minutes. Then, put the cake in and bake at 230 degrees Celsius for 7 minutes.
Bake pizza in an oil-free fryer
As for the air fryer, bake at 200 degrees Celsius for 10 minutes.
Finished product
The crispy crust, the chicken and sweet vegetables mixed with greasy cheese make you eat this piece and eat another piece.
You can serve with ketchup and chili sauce to add more flavor to the dish!');
Insert into Recipe(rName, cID, Image, Difficulty, Time, uID, rDescription, Guideline) values ('Vegetarian pizza','1','https://cdn.tgdd.vn/Files/2020/04/21/1250680/cach-lam-banh-pizza-chay-bang-noi-chien-khong-dau-10.jpg','Easy','60' ,'4',
'Pizza made with only weed',
'Process materials
Buy tomatoes, wash, cut tomatoes and squeeze out tomato juice. Peel off the skin and chop the tomatoes.
Sweet corn is washed, and the corn kernels removed.
The basil is picked up and washed with clean water.
Onions are washed, peeled and cut into small pieces with a knife.
Wash the sweet peppers, remove the seeds and cut into small pieces. Wash hot peppers, remove stems and cut into small pieces.
Make ketchup
Pour 1 tablespoon of cooking oil into the pan, turn on the heat and heat the oil. When the oil is hot, add the onions and saute.
When onions are fragrant, you add tomatoes and tomato juice to stir-fry.
When the tomatoes are about to ripen, season them with a little MSG to taste, when the tomatoes are cooked, turn off the heat and let it cool.
When the tomatoes have cooled, put the tomatoes in a green blender, grind until the tomatoes are smooth.
Add filling for the cake
Place the pizza base on a clean surface, proceed to spread olive oil around the base of the cake.
Pour ketchup over the cake and spread evenly.
Sprinkle some grated cheese, onion, sweet corn, chili on the cake and a thick layer of cheese on the top layer is ready to bake.
Bake
Put the cake in an air fryer, turn on the pot at 180 degrees C and bake the cake for 7 minutes. After 7 minutes, you take the cake out and cut it into small pieces and you can use it right away.
Finished product
Freshly made vegetarian pizza with the characteristic aroma of cheese, delicious sponge cake, fatty pan cake flavor mixed with a strong tomato sauce will be the ideal breakfast for every family. You can also add vegetarian sausages, vegetarian rolls, mushrooms to make the filling for the cake.');
Insert into Recipe(rName, cID, Image, Difficulty, Time, uID, rDescription, Guideline) values ('Caesar salad with garlic butter bread','2','https://cdn.tgdd.vn/2021/11/CookRecipe/Avatar/salad-caesar-banh-mi-bo-toi-thumbnail.jpg','Easy','60' ,'4',
'Caesar salad made with a lot of vegetable and garlic butter bread',
'Minced garlic and canned fish
You smash about 6 cloves of garlic, peel off the skin and use a knife to mince the garlic. While mincing the garlic, add about 1/2 teaspoon of salt, mix and mince it with the garlic.
With pickled canned fish, you filter out the bones and drain off the water, then mince the canned fish. Mix minced garlic and canned fish together, mince again until the mixture is smooth and smooth.
Tip: To make the mixture smoother and save more time, you can put it in a blender to puree it.
Step 1 Mince garlic and canned fish Caesar salad with garlic butter bread
Mix salad dressing
You prepare a mixing bowl, put the minced garlic and canned fish mixture in the bowl, then add 2 yolks, 1 tablespoon Dijon mustard (about 18g), 1/2 teaspoon salt and squeeze about 1/ 2 lemons. Then use a whisk to beat the yolks and mix well.
You put about 300ml of vegetable oil into a spray bottle and then stir the sauce mixture while slowly adding the vegetable oil, avoiding pouring once will easily damage the mixture. Mix well until the mixture is smooth, smooth and turns light yellow.
Next, put about 70g of parmesan cheese (grated) into the sauce bowl, mix well.
Step 2 Mix salad dressing Caesar salad with garlic bread
Mix the garlic butter
Put 200g of unsalted butter in a bowl, use a spatula to mash the butter. Then mince 4-6 garlic cloves and a little parsley into a butter bowl, add 80g of parmesan cheese. Next, stir the mixture together.
Step 3 Mix the garlic butter mixture Caesar salad with garlic butter bread
Butter and toast
First, to stabilize the oven temperature, preheat the oven to 160 degrees Celsius for 10 minutes.
Next, cut the bread in half into 2 large slices, spread the garlic butter mixture evenly over the bread.
Line a layer of foil on a baking tray and then place the bread with sauce on the tray into the oven, bake the bread at 205 degrees Celsius for 10-12 minutes.
Next, you cut the bread into long bars and then cut them into small squares.
Step 4 Butter and toasted Caesar Salad with Garlic Bread
Mix salad
When you buy Roman lettuce, you choose to pick up young leaves, remove deep, shriveled leaves. Then cut into bite-sized pieces, wash and dry.
Put the lettuce in a bowl, add about 1 pinch of salt and a little salad dressing, mix well to absorb the sauce evenly, and you can put the salad on a plate.
Step 5 Mix salad Caesar salad with garlic butter bread
Finished product
Caesar salad with garlic butter bread with sweet and crispy Roman vegetables soaked in greasy, salty and salty sauce, crispy bread with a strong garlic flavor served with vegetables makes it more delicious and attractive. You can add cheese on top to add more fat to the caesar salad.
Step 6 Finished Caesar Salad with Butter Garlic Bread');
Insert into Recipe(rName, cID, Image, Difficulty, Time, uID, rDescription, Guideline) values ('Chicken breast caesar salad','2','https://cdn.tgdd.vn/2021/11/CookRecipe/Avatar/salad-caesar-uc-ga-thumbnail.jpg','Easy','45' ,'4',
'Chicken breast caesar salad made from chiken breast and caesar salad',
'Prepare and marinate chicken breasts
To eliminate the smell of chicken breast after buying, you can wash it with water, then rub salt around the chicken breast, then rinse with water 2-3 times and then drain.
Marinate the chicken with 1 teaspoon salt and 1 teaspoon pepper and 20ml olive oil, spread evenly on both sides of the meat, add a few rosemary leaves and marinate for 10-15 minutes for the meat to absorb the spices.
Make a side dish of bread
Cut off 4 edges of the sandwich, leaving only the white flesh. Then, cut the bread into long pieces and then cut them into small squares for a plate.
Next, add about 1 teaspoon of salt and pepper, sprinkle evenly all over the bread surface and add 20-30 ml of olive oil, mix well.
Next, put the bread in the oven at 150 degrees Celsius for 20 minutes.
Step 2 Make Bread with Chicken Breast Caesar Salad
Mix salad dressing
To make salad dressing, first peel the garlic, cut it into thin slices, and chop the lemon zest into a blender.
Next, put in the blender 1 tablespoon yellow mustard, 1 can of anchovy, 50g parmersan cheese, 1/3 teaspoon salt, 1/3 teaspoon pepper, finally squeeze about 1/2 more. yellow lemon into the machine.
Then, close the lid of the machine and puree the mixture until smooth. Pour the mixture into a bowl, add 100g of mayonnaise and mix it all together.
Step 3 Mix salad dressing Chicken breast caesar salad
Boil the egg
Put the pot on the stove, put about 500ml of water in the pot, bring to a boil over medium heat. When the water starts to boil, slowly add the eggs and boil for 5-10 minutes depending on how ripe the yolk is.
Once cooked, peel off the shell and cut into quarters.
How to boil eggs that are easy to peel:
When boiling eggs, add a little vinegar or salt to the pot of water, both to prevent the eggs from breaking during the boiling process, and to make it easier to peel the eggs.
Or you can also put a few slices of lemon in the pot to help peel it off faster.
In addition, you can also refer to some quick egg peeling tips from Dien May XANH.
Step 4 Boil Eggs Chicken Breast Caesar Salad
Pan-fry chicken breast
Put the pan on the stove, add 2 tablespoons of olive oil, when the oil is hot, add the chicken and sauté each side for about 5-7 minutes with medium heat until the chicken is cooked and golden, then remove the chicken to a plate.

Then, wait for the chicken to cool down, then cut it into bite-sized pieces.

Step 5 Pan-Fry Chicken Breasts Chicken Breast Caesar Salad
Mix salad
Now to complete todays salad, wash the lettuce and cherry tomatoes, drain. Then, cut the lettuce into small pieces, and cut the cherry tomatoes in half, put everything in a bowl with 2-3 tablespoons of salad dressing, mix well.

Next, arrange the vegetables on a plate, then arrange the chicken breasts and eggs alternately, sprinkle the toast around and sprinkle a little more cheese and you are done.');
Insert into Recipe(rName, cID, Image, Difficulty, Time, uID, rDescription, Guideline) values ('Standard mashed potatoes','3','https://cdn.tgdd.vn/2020/07/CookProduct/easy-microwave-mashed-potatoes-3059678hero-01-520a91abceb44719ae5a24a179af8645-1200x676.jpg','Easy','60' ,'4',
'Usual mashed potatoes',
'Preliminary processing of potatoes
After the potatoes come back, you need to prepare them by using cold water and gently scrubbing the outer skin of the potatoes. To make sure your potatoes are clean, you can use a small brush to scrub the potatoes.
This way, the dirt on the outside of the potato skin will be removed in the best way.
Next, to make the mashed potato mixture smoother, you need to remove the skin of the potatoes before boiling.
Boiled potatoes
Place the prepared potatoes in a large pot and pour in cold water just enough to cover the potatoes. Wait until the water is bubbling, then lower the heat and continue to cook for 10-20 minutes until the potatoes are cooked.
You can check if a potato is done by using a chopstick or fork, then inserting it into the potato. If the potatoes disintegrate when you insert a fork, your potatoes are cooked. To add flavor to potatoes, you can add a pinch of salt when boiling.
Note: Do not add hot water in the beginning and cover when boiling, this will cause your potatoes to cook unevenly and cause swelling on the inside.
Make mashed potatoes
Once the potatoes are done, you strain the water out, leave the potatoes and start mashing. To make the mashing process easier, add softened butter before mashing.
You can use a fork or spoon to mash the potatoes. To make the mixture more elastic and top, mix them with milk or heated chicken broth.
Tip: Depending on the type of potato you combine with different amounts of ingredients. Do not add too much milk or chicken broth, it will make your mashed potato mixture loose!
Finished product
Mashed potatoes can be eaten with dishes such as fried chicken, grilled chicken, soup ... To enjoy, you just need to add a little salt, pepper or butter if you like a bit more fat. Eating when hot will bring out the best taste, so try to use it as soon as you are done.');
Insert into Recipe(rName, cID, Image, Difficulty, Time, uID, rDescription, Guideline) values ('Cheese baked potatoes','3','https://cdn.tgdd.vn/2020/07/CookRecipe/Avatar/khoai-tay-dut-lo-pho-mai-thumbnail.jpg','Easy',' 90' ,'4',
'Cheese baked with potatoes',
'Process materials
After buying potatoes, wash them thoroughly. Use a knife to slit along the potato until all the tubers are gone, taking care not to cut the potatoes off completely.
After slicing, soak the cut potatoes in salted water for about 10 minutes to prevent them from turning black.
Trick you:
In order for the baked potatoes to be crispy and more flavorful, in this preliminary process you do not need to peel the outer skin of the potatoes.
Also, to cut the potatoes without falling apart, place them between the two chopsticks.
Preparing other ingredients
Cut the cheese into 6 pieces about the size of a potato. Peel the garlic, wash and mince it. Minced rosemary leaves.
Next, you proceed to mince the bacon!
Put the butter in the microwave and turn on the defrost setting for about 20 to 25 seconds until the butter is completely melted.
Butter and bake potatoes
After the butter has melted completely. Take out the butter, add 1/2 teaspoon of salt and 1/2 teaspoon of ground pepper to the butter cup, then stir well to add more flavor to the dish!
Next, spread butter on each slice of the potato, making sure to cover the surface of the potato evenly!
Then, put the potatoes in the oven and bake at 200 degrees Celsius for 1 hour until the potato skin is crispy and the inside is soft.
Fried bacon
While waiting for the potatoes to cook, put a pan on the stove, add oil and fry the bacon until golden and crispy. Place freshly fried bacon on absorbent paper to remove excess fat.
Making baked potatoes
After the potatoes are done baking, take them out of the oven, let them cool down for about 3 minutes, then continue to put cheese in between the potato slices. Slice the remaining cheese and sprinkle over the top of the potatoes.
Then, put the potatoes back in the oven for 5 minutes at the same temperature so that the cheese is completely melted.
Complete
Take the potatoes out of the oven. Drizzle sour cream or yogurt and minced rosemary over the potatoes. Continue to sprinkle with bacon. Your dish is done!');
Insert into Recipe(rName, cID, Image, Difficulty, Time, uID, rDescription, Guideline) values ('Simple Baked Potatoes','3','https://cdn.tgdd.vn/2020/11/CookRecipe/Avatar/khoai-tay-dut-lo-thumbnail.jpg','Easy','30' ,'1',
'Simple potatoes which is baked',
'Potato processing
When you buy potatoes, soak them in dilute salt water for 15 minutes, then rinse them with water, and at the same time use a brush to scrub all the dirt and sand on the potato skins.
Cut the potatoes into thin slices, do not separate, leaving 1cm below.
Tip: To not cut the potatoes, you can use the chopsticks 2 below to cut the potatoes.
Make potato sauce
You put the pan on the stove on medium heat, wait until the pan is hot, add the butter, olive oil, peeled and smashed garlic, 3 sprigs of thyme, cook for about 3-4 minutes until the butter melts and the garlic turns golden. filter through a sieve.
Spread the sauce over the potatoes
You spread the butter sauce all around the potatoes, sprinkle with a little salt and pepper.
Bake potatoes
You turn on the oven 10 minutes before at a temperature of 200 degrees Celsius so that the temperature in the oven is stable.
First baking: You put the potatoes in the oven for 30 minutes at a temperature of 200 degrees Celsius.
Next, remove the tray from the oven, sprinkle with 1 sprig of crushed thyme (or other herb of your choice). Spread a layer of butter sauce evenly over the potatoes.
Second baking: You put the potatoes in the oven for another 30 minutes at a temperature of 200 degrees Celsius, until the potatoes are crispy on the edges.
Finished product
So the delicious baked potato dish is finished, the potato with a crispy crust on the outside, soft and fragrant inside with a rich, fatty flavor with the characteristic aroma of thyme, will surely satisfy you. Fastidious diners, enjoy.');
Insert into Recipe(rName, cID, Image, Difficulty, Time, uID, rDescription, Guideline) values ('Cheese Beef Hamburger','4','https://cdn.tgdd.vn/Files/2017/07/03/999119/cach-lam-hamburger-bo-pho-mai-sieu-don-gian-tai-nha.jpg','Easy','40 ' ,'4',
'Hamburger made from beef mix with cheese',
'Marinated beef
Stir minced beef with spices including 2 teaspoons of sugar, 3 teaspoons of seasoning, 1/2 teaspoon of salt, 1/2 cup of breadcrumbs and 1 tablespoon of cooking oil. Then marinate for 15 minutes.
Wash the meat into round balls, fry it until cooked. When frying, flatten the meatballs. You can add grated cheese if you like.
Complete.
Cut the bread in half and spread chili sauce, mayonnaise, in turn add lettuce, tomatoes, cheese, fried beef, turn the other half of the bread upside down and its done.
Finished product
The crust is crispy, the beef is seasoned just right, served with fatty leopard cheese, a little tomato and lettuce to balance the taste, making the dish not boring at all but still delicious and steaming. guide');
Insert into Recipe(rName, cID, Image, Difficulty, Time, uID, rDescription, Guideline) values ('French Beef Stew with Vegetables','5','https://cdn.tgdd.vn/2021/05/CookProduct/3-1200x676.jpg','Easy','60' ,'4',
'Stew made from Beef and vegetables with French style',
'Preliminary beef
Buy beef, wash it, put it in a basket to drain the water, and then cut it into bite-sized squares with a knife.
How to properly prepare beef?
Beef should be cut across the grain so that the meat is tender and tastier.
You can put the meat in the refrigerator for about 15-20 minutes before slicing, helping the meat to shape, easy to see the grain of the meat when cutting.
Buy beef to avoid soaking and washing for too long in water, causing the sweetness in the meat to be reduced, affecting the taste of the meat.
After you buy the piece of meat, you should use a damp towel to absorb the water on the surface of the meat, use the ginger that has been lightly grilled, pound it, and then rub the meat evenly.
Rinse with water to effectively eliminate odors.
See details: How to properly prepare beef
Prepare other ingredients
Carrots, onions, potatoes after buying, peeled and washed. Use a knife to cut into bite-sized squares.
Celery is washed, cut into pieces about 2-3 knuckles long. Wash thyme leaves and drain.
White Ganoderma lucidum gently wash with clean water, separate each small mushroom ear, wait for the water to drain.
Marinated beef
Marinate the meat with 1 tablespoon seasoning, 1 little ground pepper, mix the meat with chopsticks in a bowl, let it rest for about 15 minutes, helping the meat to absorb the seasoning.
Beef stew
Place on the stove a pan, heat 2 tablespoons of cooking oil, add the beef and sauté it over medium-high heat. Until the meat turns pale, the meat is firm, add 4 tablespoons of tomato sauce, 3 tablespoons of oyster sauce, mix well.
Add water to the pan so that the water just covers the meat, season with 1 teaspoon sugar, 1/2 teaspoon salt, stir gently to help the seasoning dissolve faster. Reduce heat to low, cover and simmer for about 40 minutes.
Stir-fry vegetables
Put another pan on the stove, add 2 tablespoons of cooking oil. When the oil is hot, add all the carrots, potatoes, onions and celery and stir-fry with your hands over high heat for about 1-2 minutes.
Continue to add all the white reishi mushrooms, 1 tablespoon of unsalted butter and stir-fry for about 2 minutes, then quickly turn off the heat.
Beef stew with vegetables
When the beef is cooked evenly, put all the lightly sautéed vegetables in the pan, add about 6 tablespoons of red wine, add 3 thyme leaves, cover and continue to cook for about 5-10 minutes, season to taste. Once you have eaten, you can turn off the stove.
Tip: When you put all the ingredients in the pan, you can put a piece of parchment paper under the lid of the pan, then cover. Makes the meat much softer.
Finished product
Put beef stew with vegetables on a plate and enjoy with the family! The dish has a glossy brown color, mixed with outstanding colors from carrots, onions, celery, ... adding a strong and attractive flavor from delicious tender beef and flavorful thyme leaves.
The taste is rich, salty and sweet, mixed with a little spicy from ground pepper to make the dish more attractive than ever.
Serve with white rice, bread or fresh vermicelli!');
Insert into Recipe(rName, cID, Image, Difficulty, Time, uID, rDescription, Guideline) values ('Spaghetti with Minced Beef Tomato Sauce','6','https://cdn.tgdd.vn/2021/11/CookRecipe/Avatar/mi-y-sot-ca-chua-bo-bam-cong-thuc-duoc-chia-se-tu-nguoi-dung-thumbnail.jpg','Easy','30' ,'4',
'Spaghetti made from Minced Beef with tomato sauce',
'Boil noodles
Put the pot on the stove, add about 700ml of water and cook on high heat. When the water boils, add 1 teaspoon of salt and 200g of spaghetti, reduce the heat to medium, when the top of the noodles touches the water, it is soft, use your hands to press all the noodles into the water.
Stir the noodles well and cook for about 8-10 minutes, then turn off the heat, then remove the boiled noodles to a basket to drain.
Scent meat
Put 200g of minced beef in a bowl, add 1/2 teaspoon of salt and 1/3 teaspoon of ground pepper and mix well. Then marinate for about 10 minutes for the beef to absorb the spices.
Make spaghetti sauce
Put the pan on the stove on medium heat, add 1 tablespoon of olive oil, wait for the oil to heat up, then add 1/2 diced onion and fry until fragrant.
Next, add the marinated minced beef and stir-fry thoroughly so that the beef does not stick together. Stir-fry for about 3 minutes until the beef is cooked.
After the beef is cooked, add all 400g of ready-made spaghetti sauce to the sautéed meat pan and stir for about 3 minutes, add 1/3 teaspoon of ground pepper to the island, then turn off the heat.
Complete
You put the boiled spaghetti on a plate, then sprinkle some minced beef sauce on top, add 1 tomato cut into a beautiful flower shape on top to decorate.');

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

