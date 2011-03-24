
package com.mboarder.bean;

/*
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * @author fnan
 * 
 *         Unicode conversion by http://rishida.net/tools/conversion/
 */
public class CategoryPage {

	private static String TAG ="CategoryPage";
	private static  String[] categoryName = { "\u65B0\u95FB\u4E2D\u5FC3",
			"\u6D77\u5916\u751F\u6D3B", "\u534E\u4EBA\u4E16\u754C",
			"\u4F53\u80B2\u5065\u8EAB", "\u5A31\u4E50\u4F11\u95F2",
			"\u60C5\u611F\u6742\u60F3", "\u6587\u5B66\u827A\u672F",
			"\u6821\u53CB\u8054\u8C0A", "\u4E61\u91CC\u4E61\u60C5",
			"\u7535\u8111\u7F51\u7EDC", "\u5B66\u672F\u5B66\u79D1",
			"\u672C\u7AD9\u7CFB\u7EDF" };

	private ArrayList<HashMap<String, String>> categoryPagePostList;
	private ArrayList<ArrayList<HashMap<String, String>>> categoryPagePostListArray;
	
	public CategoryPage() {
		categoryPagePostList = new ArrayList<HashMap<String, String>>();
		categoryPagePostListArray = new ArrayList<ArrayList<HashMap<String, String>>>();
	}
	
	public ArrayList<ArrayList<HashMap<String, String>>> getCategoryPagePostListArray()
	{
		return categoryPagePostListArray;
		
	}
	
	public void setCategoryPagePostListArray(ArrayList<ArrayList<HashMap<String, String>>> aArray)
	{
		this.categoryPagePostListArray = aArray;
	}
	public void init(){
		// Section 0, Xin Wen Zhong Xin		
		this.add("\u4E9A\u6D32\u65B0\u95FB", "AsiaNews",
				"http://www.mitbbs.com/mobile/mbbsdoc.php?board=AsiaNews");
		
		this.add("\u6FB3\u65B0\u65B0\u95FB", "AustraliaNews",
				"http://www.mitbbs.com/mobile/mbbsdoc.php?board=AustraliaNews");
		this.add("\u52A0\u62FF\u5927\u65B0\u95FB", "CanadaNews",
				"http://www.mitbbs.com/mobile/mbbsdoc.php?board=CanadaNews");
		this.add("\u6B27\u6D32\u65B0\u95FB", "EuropeNews",
				"http://www.mitbbs.com/mobile/mbbsdoc.php?board=EuropeNews");
		this.add("\u79FB\u6C11\u65B0\u95FB", "ImmigrationNews",
				"http://www.mitbbs.com/mobile/mbbsdoc.php?board=ImmigrationNews");
		this.add("\u5730\u533A\u4FE1\u606F", "LocalInfo",
				"http://www.mitbbs.com/mobile/mbbsdoc.php?board=LocalInfo");
		this.add("\u6D77\u5916\u7126\u70B9", "OverseasFocus",
				"http://www.mitbbs.com/mobile/mbbsdoc.php?board=OverseasFocus");
		this.add("\u8D22\u7ECF\u65B0\u95FB", "BusinessNews",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=BusinessNews");
		this.add("\u4E2D\u56FD\u65B0\u95FB", "ChinaNews",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=ChinaNews");
		this.add("\u4E2D\u56FD\u65B0\u95FB2", "ChinaNews2",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=ChinaNews2");
		this.add("\u4FA6\u63A2\u4E0E\u6267\u6CD5", "Detective",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Detective");
		this.add("\u6350\u8D60\u53CA\u6551\u52A9", "Donation",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Donation");
		this.add("\u672A\u540D\u5927\u4E8B\u4EF6", "GreatPit",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=GreatPit");
		this.add("\u7126\u70B9\u65B0\u95FB", "Headline",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Headline");
		this.add("\u53F2\u6D77\u94A9\u6C89", "History",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=History");
		this.add("\u519B\u4E8B\u5929\u5730", "Military",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Military");
		this.add("\u519B\u4E8B\u5929\u57302", "Military",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Military2");
		this.add("\u65F6\u653F\u65B0\u95FB", "MiscNews",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=MiscNews");
		this.add("\u5965\u8FD0\u7248", "Olympics",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Olympics");
		this.add("\u5A31\u4E50\u65B0\u95FB", "PopNews",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=PopNews");
		this.add("\u9177\u513F\u65B0\u95FB", "QueerNews",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=QueerNews");
		this.add("\u7231\u56FD\u5F3A\u56FD", "RisingChina",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=RisingChina");
		this.add("\u5E0C\u671B\u7684\u7530\u91CE", "RuralChina",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=RuralChina");
		this.add("\u6C11\u4E3B\u6C99\u9F99", "Salon",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Salon");
		this.add("\u79D1\u6280\u65B0\u95FB", "ScitechNews",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=ScitechNews");
		this.add("\u4F53\u80B2\u65B0\u95FB", "SportsNews",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=SportsNews");
		this.add("\u4F17\u8BF4\u7EB7\u7EAD", "talk",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=talk");
		this.add("\u6D77\u5CE1\u4E24\u5CB8", "TheStrait",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=TheStrait");
		this.add("\u7F8E\u56FD\u65B0\u95FB", "USANews",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=USANews");
		this.add("\u5168\u7403\u77AD\u671B", "WorldNews",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=WorldNews");
		categoryPagePostListArray.add(new ArrayList(new HashSet( categoryPagePostList)));
		categoryPagePostList.clear();
		
		// Section 1, Hai Wai Sheng Huo		
		this.add("\u843D\u5730\u751F\u6839(EB2EB3)", "EB23",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=");
		this.add("\u7533\u8BF7\u79FB\u6C11\u7B7E\u8BC1", "I140",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=I140");
		this.add("\u8F6C\u6362\u79FB\u6C11\u7B7E\u8BC1", "I485",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=I485");
		this.add("\u843D\u5730\u751F\u6839", "Immigration",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Immigration");
		this.add("\u8F66\u8F6E\u4E0A\u7684\u4F20\u5947", "Automobile",
				"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Automobile");
		this.add("\u56DE\u56FD", "BackHome",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=BackHome");
		this.add("\u8BC1\u5238\u4E2D\u56FD", "ChinaStock",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=ChinaStock");
		this.add("\u5206\u7C7B\u5E7F\u544A", "Classified",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Classified");
		this.add("\u7535\u5B50\u5546\u52A1", "ebiz",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=ebiz");
		this.add("\u53D1\u8003\u9898", "Faculty",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Faculty");
		this.add("\u6211\u7231\u6211\u5BB6", "Family",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Family");
		this.add("\u4E8C\u624B\u5E02\u573A", "FleaMarket",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=FleaMarket");
		this.add("\u753B\u997C\u5145\u9965", "Food",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Food");
		this.add("\u5409\u798F\u5361", "GiftCard",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=GiftCard");
		this.add("\u5927\u8BDD\u897F\u6E38", "Gowest",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Gowest");
		this.add("\u97F3\u50CF\u5929\u5730", "HiFi",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=HiFi");
		this.add("\u623F\u5C4B\u51FA\u79DF/\u6C42\u79DF", "HouseRental",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=HouseRental");
		this.add("\u6295\u8D44", "Investment",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Investment");
		this.add("\u5F85\u5B57\u95FA\u4E2D", "JobHunting",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=JobHunting");
		this.add("\u62DB\u8058/\u6C42\u804C", "JobMarket",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=JobMarket");
		this.add("\u5BB6\u5C45\u751F\u6D3B", "Living",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Living");
		this.add("\u6C42\u533B\u95EE\u836F", "Medicine",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Medicine");
		this.add("\u6D77\u5916\u7406\u8D22", "Money",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Money");
		this.add("\u6211\u7231\u5B9D\u5B9D", "NextGeneration",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=NextGeneration");
		this.add("\u779F\u6768\u8FC7\uFF0C\u5B69\u89E6\u8FC7\u516D\u7A74", "Overseas",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Overseas");
		this.add("\u4E3A\u4EBA\u7236\u6BCD", "Parenting",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Parenting");
		this.add("\u7701\u94B1\u4E00\u65CF", "PennySaver",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=PennySaver");
		this.add("\u535A\u58EB\u540E", "Postdoc",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Postdoc");
		this.add("\u6D77\u5F52", "Returnee",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Returnee");
		this.add("\u6D77\u5916\u4EE3\u8D2D", "SellAbroad",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=SellAbroad");
		this.add("\u8D2D\u7269\u5929\u5802", "shopping",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=shopping");
		this.add("\u521B\u4E1A", "StartUp",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=StartUp");
		this.add("\u80A1\u6D77\u5F04\u6F6E", "Stock",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Stock");
		this.add("\u4EA4\u7A0E\u4E0E\u9000\u7A0E", "TAX",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=TAX");
		this.add("\u7B7E\u8BC1", "Visa",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Visa");
		this.add("\u672A\u540D\u4E4B\u5BB6", "WeiMingHome",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=WeiMingHome");
		this.add("\u4E0A\u73ED\u4E00\u65CF", "Working",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Working");
		categoryPagePostListArray.add(new ArrayList(new HashSet( categoryPagePostList)));
		categoryPagePostList.clear();
		
		// Section 2, Hua Ren Shi Jie 		
		this.add("\u963f\u62c9\u5df4\u9a6c", "Alabama",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Alabama");
		this.add("\u4e9a\u5229\u6851\u90a3", "Arizona",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Arizona");
		this.add("\u963f\u80af\u8272", "ARKANSAS",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=ARKANSAS");
		this.add("\u6ce2\u58eb\u987f\u5730\u533a", "Boston",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Boston");
		this.add("\u5357\u5317\u5361\u5730\u533a", "Carolinas",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Carolinas");
		this.add("\u829d\u52a0\u54e5\u5730\u533a", "Chicago",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Chicago");
		this.add("\u79d1\u7f57\u62c9\u591a", "Colorado",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Colorado");
		this.add("\u5eb7\u6d85\u72c4\u683c", "Connecticut",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Connecticut");
		this.add("\u4f5b\u7f57\u91cc\u8fbe\u5dde", "Florida",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Florida");
		this.add("\u4f50\u6cbb\u4e9a\u5dde", "Georgia",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Georgia");
		this.add("\u5370\u7b2c\u5b89\u7eb3", "Indiana",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Indiana");
		this.add("\u7231\u8377\u534e", "Iowa",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Iowa");
		this.add("\u582a\u8428\u65af", "Kansas",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Kansas");
		this.add("\u80af\u5854\u57fa", "Kentucky",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Kentucky");
		this.add("\u6d1b\u6749\u57fa\u5730\u533a", "LosAngeles",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=LosAngeles");
		this.add("\u8def\u6613\u65af\u5b89\u5a1c", "Louisiana",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Louisiana");
		this.add("\u5bc6\u6b47\u6839", "Michigan",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Michigan");
		this.add("\u660e\u5c3c\u82cf\u8fbe", "Minnesota",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Minnesota");
		this.add("\u5bc6\u897f\u897f\u6bd4", "Mississippi",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Mississippi");
		this.add("\u5bc6\u82cf\u91cc", "Missouri",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Missouri");
		this.add("\u5185\u5e03\u62c9\u65af\u52a0", "Nebraska",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Nebraska");
		this.add("\u5185\u534e\u8fbe", "Nevada",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Nevada");
		this.add("\u65b0\u6cfd\u897f", "NewJersey",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=NewJersey");
		this.add("\u65b0\u58a8\u897f\u54e5", "NewMexico",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=NewMexico");
		this.add("\u7ebd\u7ea6\u5730\u533a", "NewYork",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=NewYork");
		this.add("\u4fc4\u4ea5\u4fc4\u5dde", "Ohio",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Ohio");
		this.add("\u4fc4\u514b\u62c9\u548c\u9a6c", "Oklahoma",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Oklahoma");
		this.add("\u4fc4\u52d2\u5188", "Oregon",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Oregon");
		this.add("\u8d39\u57ce\u5730\u533a", "PHILADELPHIA",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=PHILADELPHIA");
		this.add("\u75de\u5b50\u5821", "Pittsburgh",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Pittsburgh");
		this.add("\u7f57\u5fb7\u5c9b", "RhodeIsland",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=RhodeIsland");
		this.add("\u5723\u8fed\u6208", "SanDiego",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=SanDiego");
		this.add("\u4e09\u85e9\u5e02\u5730\u533a", "SanFrancisco",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=SanFrancisco");
		this.add("\u897f\u96c5\u56fe\u5730\u533a", "Seattle",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Seattle");
		this.add("\u7530\u7eb3\u897f", "Tennessee",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Tennessee");
		this.add("\u5fb7\u514b\u8428\u65af\u5dde", "Texas",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Texas");
		this.add("\u7f8e\u56fd\u65b0\u95fb", "USANews",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=USANews");
		this.add("\u72b9\u4ed6\u5dde", "Utah",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Utah");
		this.add("\u7ef4\u5409\u5c3c\u4e9a\u5dde", "Virginia",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Virginia");
		this.add("\u534e\u76db\u987f\u7279\u533a", "WashingtonDC",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=WashingtonDC");
		this.add("\u5a01\u65af\u5eb7\u661f", "Wisconsin",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Wisconsin");
		this.add("\u4e9a\u6d32\u65b0\u95fb", "AsiaNews",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=AsiaNews");
		this.add("\u6fb3\u65b0\u65b0\u95fb", "AustraliaNews",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=AustraliaNews");
		this.add("\u52a0\u62ff\u5927\u65b0\u95fb", "CanadaNews",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=CanadaNews");
		this.add("\u6b27\u6d32\u65b0\u95fb", "EuropeNews",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=EuropeNews");
		this.add("\u79fb\u6c11\u65b0\u95fb", "ImmigrationNews",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=ImmigrationNews");
		this.add("\u5730\u533a\u4fe1\u606f", "LocalInfo",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=LocalInfo");
		this.add("\u6d77\u5916\u7126\u70b9", "OverseasFocus",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=OverseasFocus");
		this.add("\u67ab\u53f6\u4e4b\u56fd", "Canada",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Canada");
		this.add("\u52a0\u62ff\u5927\u65b0\u95fb", "CanadaNews",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=CanadaNews");
		this.add("\u8499\u7279\u5229\u5c14", "Montreal",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Montreal");
		this.add("\u6e25\u592a\u534e", "Ottawa",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Ottawa");
		this.add("\u591a\u4f26\u591a", "Toronto",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Toronto");
		this.add("\u6e29\u54e5\u534e", "Vancouver",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Vancouver");
		this.add("\u6fb3\u5927\u5229\u4e9a", "Australia",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Australia");
		this.add("\u6d77\u5916\u534e\u4eba", "Chinese",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Chinese");
		this.add("\u6b27\u5bb6\u5927\u9662", "Europe",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Europe");
		this.add("\u5fb7\u610f\u5fd7", "Germany",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Germany");
		this.add("\u4e1c\u65b9\u4e4b\u73e0", "HongKong",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=HongKong");
		this.add("\u65e5\u672c", "Japan",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Japan");
		this.add("\u671d\u97e9\u7814\u7a76", "Korea",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Korea");
		this.add("\u4e2d\u56fd\u5927\u9646", "Mainland",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Mainland");
		this.add("\u65b0\u897f\u5170", "NewZealand",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=NewZealand");
		this.add("\u65b0\u52a0\u5761", "Singapore",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Singapore");
		this.add("\u7f8e\u4e3d\u4e4b\u5c9b", "Taiwan",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Taiwan");
		this.add("\u82f1\u56fd", "UnitedKingdom",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=UnitedKingdom");
		categoryPagePostListArray.add(new ArrayList(new HashSet(categoryPagePostList)));
		categoryPagePostList.clear();

		// Section 3, Ti Tu Jian Shen 		
		this.add("\u7fbd\u6bdb\u7403", "Badminton",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Badminton");
		this.add("\u68d2\u7403", "Baseball",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Baseball");
		this.add("\u7bee\u7403", "Basketball",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Basketball");
		this.add("\u53f0\u7403", "Billiards",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Billiards");
		this.add("\u4fdd\u9f84\u7403", "Bowling",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Bowling");
		this.add("\u6865\u724c", "Bridge",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Bridge");
		this.add("\u8c61\u68cb", "Chess",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Chess");
		this.add("\u81ea\u884c\u8f66\u8fd0\u52a8", "Cycling",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Cycling");
		this.add("\u4e00\u5929\u5230\u665a\u4e0a\u94a9\u7684\u9c7c", "Fishing",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Fishing");
		this.add("\u5065\u8eab\u4ff1\u4e50\u90e8", "Fitness",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Fitness");
		this.add("\u5929\u624d\u5c0f\u535a\u58eb", "FlashGame",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=FlashGame");
		this.add("\u6a44\u6984\u7403", "Football",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Football");
		this.add("\u865a\u62df\u4eba\u751f", "Game",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Game");
		this.add("\u9ed1\u767d\u5b50", "Go",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Go");
		this.add("\u9ad8\u5c14\u592b", "Golf",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Golf");
		this.add("\u821e\u5200\u5f04\u67aa", "GunsAndGears",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=GunsAndGears");
		this.add("\u51b0\u7403", "Hockey",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Hockey");
		this.add("\u5065\u5eb7\u51cf\u80a5", "loseweight",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=loseweight");
		this.add("\u6b66\u672f", "MartialArts",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=MartialArts");
		this.add("\u9ebb\u96c0\u5b66\u56ed", "MJ",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=MJ");
		this.add("NBA", "NBA",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=NBA");
		this.add("\u5927\u5b66\u4f53\u80b2", "NCAA",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=NCAA");
		this.add("\u5965\u8fd0\u7248", "Olympics",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Olympics");
		this.add("\u6237\u5916\u6d3b\u52a8", "Outdoors",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Outdoors");
		this.add("\u7ff1\u7fd4\u84dd\u5929", "Pilot",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Pilot");
		this.add("\u4e52\u4e53\u7403", "Pingpong",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Pingpong");
		this.add("\u98ce\u9a70\u7535\u63a3", "Racing",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Racing");
		this.add("\u8dd1\u6b65\u4e0d\u606f", "Running",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Running");
		this.add("\u96ea\u5c71\u98de\u5f27", "Ski",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Ski");
		this.add("\u6eda\u5427\uff0c\u8db3\u7403\uff01", "Soccer",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Soccer");
		this.add("\u4f53\u80b2\u65b0\u95fb", "SportsNews",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=SportsNews");
		this.add("\u78a7\u6c34\u95f2\u60c5", "Swimming",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Swimming");
		this.add("\u7f51\u7403", "Tennis",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Tennis");
		this.add("\u5fb7\u5dde\u6251\u514b", "TexasHoldem",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=TexasHoldem");
		this.add("\u56db\u6d77\u4e3a\u5bb6", "Travel",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Travel");
		this.add("\u89c6\u9891\u6e38\u620f", "TVGame",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=TVGame");
		this.add("\u6392\u7403", "VolleyBall",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=VolleyBall");
		this.add("\u4e3e\u91cd\u82e5\u8f7b", "Weightlifting",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Weightlifting");
		this.add("\u745c\u4f3d&\u666e\u62c9\u63d0", "yoga",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=yoga");
		categoryPagePostListArray.add(new ArrayList(new HashSet( categoryPagePostList)));
		categoryPagePostList.clear();

		// Section 4, Yu Le Xiu Xian 		
		this.add("\u661f\u5ea7\u7269\u8bed", "astrology",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=astrology");
		this.add("\u66f2\u82d1\u6742\u575b", "AudioBook",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=AudioBook");
		this.add("\u672a\u540d\u5f62\u8c61\u79c0", "Avatar",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Avatar");
		this.add("\u5a31\u4e50\u516b\u5366", "bagua",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=bagua");
		this.add("\u5927\u8111\u5de5\u4f5c\u5ba4", "BrainTeaser",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=BrainTeaser");
		this.add("\u53e4\u5178\u97f3\u4e50", "ClassicalMusic",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=ClassicalMusic");
		this.add("\u6536\u85cf", "Collectibles",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Collectibles");
		this.add("\u7f8e\u56fd\u7535\u89c6", "CouchPotato",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=CouchPotato");
		this.add("\u624b\u5de5\u827a", "Craft",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Craft");
		this.add("\u8f7b\u821e\u98de\u626c", "Dance",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Dance");
		this.add("DVD", "DVD",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=DVD");
		this.add("\u7535\u5b50\u7ade\u6280", "E-Sports",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=E-Sports");
		this.add("\u6dd8\u73cd\u6362\u5b9d", "Exchange",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Exchange");
		this.add("\u7f8e\u4e3d\u65f6\u5c1a", "Fashion",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Fashion");
		this.add("\u4e00\u5929\u5230\u665a\u4e0a\u94a9\u7684\u9c7c", "Fishing",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Fishing");
		this.add("\u535a\u5f69", "Gamble",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Gamble");
		this.add("\u865a\u62df\u4eba\u751f", "Game",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Game");
		this.add("\u62c8\u82b1\u60f9\u8349", "gardening",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=gardening");
		this.add("\u7231\u79c0", "iShow",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=iShow");
		this.add("\u8bfb\u4e66\u542c\u6b4c\u770b\u7535\u5f71", "LeisureTime",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=LeisureTime");
		this.add("\u65e0\u9650\u5f71\u8bdd", "Movie",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Movie");
		this.add("\u5929\u7c41\u4e4b\u97f3", "Music",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Music");
		this.add("\u4e50\u624b\u4e4b\u5bb6", "MusicPlayer",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=MusicPlayer");
		this.add("\u6211\u7231\u4e16\u754c\u676f", "MyActivity",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=MyActivity");
		this.add("\u6237\u5916\u6d3b\u52a8", "Outdoors",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Outdoors");
		this.add("\u6444\u5f71\u4f5c\u54c1", "PhotoForum",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=PhotoForum");
		this.add("\u6444\u5f71\u5668\u6750", "PhotoGear",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=PhotoGear");
		this.add("\u8d34\u56fe\u5427", "Pics",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Pics");
		this.add("\u5a31\u4e50\u65b0\u95fb", "PopNews",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=PopNews");
		this.add("\u6447\u6eda\u97f3\u4e50", "Rock",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Rock");
		this.add("\u97f3\u4e50\u542c\u5802", "Sound_of_Music",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Sound_of_Music");
		this.add("\u8d85\u7ea7\u79c0\u573a", "Supershow",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Supershow");
		this.add("\u56db\u6d77\u4e3a\u5bb6", "Travel",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Travel");
		this.add("\u4e2d\u6587\u7535\u89c6", "TVChinese",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=TVChinese");
		this.add("\u89c6\u9891\u6e38\u620f", "TVGame",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=TVGame");
		this.add("\u672a\u540d\u6c34\u4e16\u754c", "WaterWorld",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=WaterWorld");
		this.add("\u672a\u540d\u7f51\u7edc\u7535\u53f0", "WebRadio",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=WebRadio");
		this.add("\u672a\u540d\u4e4b\u5bb6", "WeiMingHome",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=WeiMingHome");
		this.add("\u672a\u540d\u6e38\u620f", "WmGame",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=WmGame");
		categoryPagePostListArray.add(new ArrayList(new HashSet( categoryPagePostList)));
		categoryPagePostList.clear();

		// Section 5, Qing Gan Za Xiang 		
		this.add("\u7ea2\u8336\u9986&\u7f51\u53cb\u4ff1\u4e50\u90e8", "Banquet",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Banquet");
		this.add("\u795d\u798f", "Blessing",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Blessing");
		this.add("\u68a6\u91cc\u82b1\u843d\u77e5\u591a\u5c11", "Dreamer",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Dreamer");
		this.add("\u9e1f\u8bed\u82b1\u9999", "EnglishChat",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=EnglishChat");
		this.add("\u4e24\u6027\u5e73\u7b49", "GenderEquality",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=GenderEquality");
		this.add("\u8c46\u853b\u5e74\u534e", "Girl",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Girl");
		this.add("\u5fc3\u60c5\u597d\u4e48\uff1f", "Heart",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Heart");
		this.add("\u809a\u76ae\u821e\u8fd0\u52a8", "Joke",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Joke");
		this.add("\u540c\u5973\u4e4b\u821e", "LES",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=LES");
		this.add("\u60c5\u7231\u5e7d\u5e7d", "Love",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Love");
		this.add("\u7537\u4eba", "man",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=man");
		this.add("\u5982\u70df\u7f51\u4e8b", "Memory",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Memory");
		this.add("\u4e2d\u5b66\u65f6\u4ee3", "MiddleSchool",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=MiddleSchool");
		this.add("\u4eba\u5230\u4e2d\u5e74", "Midlife",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Midlife");
		this.add("\u5fc3\u6709\u6240\u5ba0", "pets",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=pets");
		this.add("\u9e4a\u6865", "Piebridge",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Piebridge");
		this.add("\u540c\u5fd7\u554a\u540c\u5fd7", "Rainbow",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Rainbow");
		this.add("\u6027\u610f\u8bc6", "Sex",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Sex");
		this.add("\u6027\u610f\u8bc62", "Sex2",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Sex2");
		this.add("50% completed", "single",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=single");
		this.add("\u65e0\u5fc3\u5462\u5583", "Whisper",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Whisper");
		categoryPagePostListArray.add(new ArrayList(new HashSet( categoryPagePostList)));
		categoryPagePostList.clear();
		
		// Section 6, Wen Xue Yi Shu  		
		this.add("\u827a\u672f\u6bbf\u5802", "Arts",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Arts");
		this.add("\u5b97\u6559\u4fe1\u4ef0", "Belief",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Belief");
		this.add("\u4e2d\u534e\u53e4\u5178\u6587\u5316", "ChineseClassics",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=ChineseClassics");
		this.add("\u4e00\u672c\u6f2b\u753b\u95ef\u5929\u6daf", "Comic",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Comic");
		this.add("\u98ce\u6c34\u7814\u7a76", "Fengshui",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Fengshui");
		this.add("\u5170\u82e5\u5bfa", "Ghost",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Ghost");
		this.add("\u8bfb\u4e66\u542c\u6b4c\u770b\u7535\u5f71", "LeisureTime",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=LeisureTime");
		this.add("\u6587\u6d77\u62fe\u8d1d", "Literature",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Literature");
		this.add("\u6587\u60c5\u5f71\u8272", "LoveNLust",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=LoveNLust");
		this.add("\u821e\u53f0\u827a\u672f", "OnStage",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=OnStage");
		this.add("\u6b4c\u5267\u201c\u9b45\u201d\u5f71", "OperaHouse",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=OperaHouse");
		this.add("\u8c08\u53e4\u8bba\u91d1\uff0c\u9ec4\u6881\u4e00\u68a6 (\u6b66\u4fa0)", "paladin",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=paladin");
		this.add("\u6d77\u68e0\u8bd7\u793e", "Poetry",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Poetry");
		this.add("\u6563\u6587.\u539f\u521b\u6587\u5b66\u677f", "Prose",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Prose");
		this.add("\u5fc3\u7406\u5206\u6790", "PsychoAnalysis",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=PsychoAnalysis");
		this.add("\u6c14\u529f [\u53ea\u8bfb]", "QiGong",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=QiGong");
		this.add("\u4e66\u9999\u4e16\u5bb6", "Reader",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Reader");
		this.add("\u661f\u9645\u6d6a\u5b50 (\u79d1\u5e7b\u5c0f\u8bf4)", "SciFiction",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=SciFiction");
		this.add("\u6027\u610f\u8bc6", "Sex",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Sex");
		this.add("\u6027\u610f\u8bc62", "Sex2",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Sex2");
		this.add("\u601d\u8003\u8005", "Thoughts",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Thoughts");
		this.add("\u8bd1\u6797", "Translation",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Translation");
		this.add("\u57fa\u7763\u4fe1\u4ef0", "TrustInJesus",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=TrustInJesus");
		this.add("\u4f5b\u9053\u5112", "Wisdom",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Wisdom");
		categoryPagePostListArray.add(new ArrayList(new HashSet( categoryPagePostList)));
		categoryPagePostList.clear();

		// Section 7, Xiao You Lian Yi 		
		this.add("\u4e2d\u56fd\u79d1\u5b66\u9662", "AC",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=AC");
		this.add("\u5b89\u5fbd\u5927\u5b66", "AHU",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=AHU");
		this.add("\u5317\u4eac\u5e7f\u64ad\u5b66\u9662", "BBI",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=BBI");
		this.add("\u4f2f\u514b\u5229", "Berkeley",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Berkeley");
		this.add("\u5317\u4eac\u7406\u5de5\u5927\u5b66", "BIT",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=BIT");
		this.add("\u5317\u4eac\u4ea4\u901a\u5927\u5b66", "BJTU",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=BJTU");
		this.add("\u5317\u4eac\u5de5\u4e1a\u5927\u5b66", "BJUT",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=BJUT");
		this.add("\u5317\u4eac\u533b\u79d1\u5927\u5b66", "BMU",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=BMU");
		this.add("\u5317\u4eac\u5e08\u8303\u5927\u5b66", "BNU",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=BNU");
		this.add("\u5317\u4eac\u822a\u7a7a\u822a\u5929\u5927\u5b66", "BUAA",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=BUAA");
		this.add("\u5317\u4eac\u5316\u5de5\u5927\u5b66", "BUCT",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=BUCT");
		this.add("\u5317\u4eac\u90ae\u7535\u5927\u5b66", "BUPT",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=BUPT");
		this.add("\u4e2d\u56fd\u653f\u6cd5\u5927\u5b66", "CUPL",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=CUPL");
		this.add("\u4e1c\u534e\u5927\u5b66\uff08\u539f\u4e2d\u7eba\u5927\uff09", "DHU",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=DHU");
		this.add("\u5927\u8fde\u7406\u5de5\u5927\u5b66", "DUT",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=DUT");
		this.add("\u534e\u4e1c\u5e08\u8303\u5927\u5b66", "ECNU",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=ECNU");
		this.add("\u534e\u4e1c\u7406\u5de5\u5927\u5b66", "ECUST",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=ECUST");
		this.add("\u590d\u65e6\u5927\u5b66", "FDU",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=FDU");
		this.add("\u54c8\u5c14\u6ee8\u5de5\u4e1a\u5927\u5b66", "HIT",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=HIT");
		this.add("\u9999\u6e2f\u79d1\u6280\u5927\u5b66", "HKUST",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=HKUST");
		this.add("\u534e\u4e2d\u79d1\u6280\u5927\u5b66", "HUST",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=HUST");
		this.add("\u5409\u6797\u5927\u5b66", "JLU",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=JLU");
		this.add("\u5170\u5dde\u5927\u5b66", "LZU",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=LZU");
		this.add("\u534e\u5317\u7535\u529b\u5927\u5b66", "NCEPU",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=NCEPU");
		this.add("\u53f0\u6e7e\u65b0\u7af9\u4ea4\u901a\u5927\u5b66", "NCTU",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=NCTU");
		this.add("\u4e1c\u5317\u5927\u5b66", "NEU",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=NEU");
		this.add("\u5357\u4eac\u5927\u5b66", "NJU",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=NJU");
		this.add("\u5357\u5f00\u5927\u5b66", "NKU",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=NKU");
		this.add("\u5357\u4eac\u822a\u7a7a\u822a\u5929\u5927\u5b66", "NUAA",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=NUAA");
		this.add("\u5357\u4eac\u7406\u5de5\u5927\u5b66", "NUST",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=NUST");
		this.add("\u897f\u5317\u5de5\u4e1a\u5927\u5b66", "NWPU",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=NWPU");
		this.add("\u897f\u5317\u5927\u5b66\uff08\u4e2d\u56fd\uff09", "NWU",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=NWU");
		this.add("\u4e2d\u56fd\u6d77\u6d0b\u5927\u5b66", "OUC",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=OUC");
		this.add("\u5317\u4eac\u5927\u5b66", "PKU",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=PKU");
		this.add("\u4eba\u6c11\u5927\u5b66", "RUC",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=RUC");
		this.add("\u56db\u5ddd\u5927\u5b66", "SCU",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=SCU");
		this.add("\u534e\u5357\u7406\u5de5", "SCUT",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=SCUT");
		this.add("\u5c71\u4e1c\u5927\u5b66", "SDU",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=SDU");
		this.add("\u4e1c\u5357\u5927\u5b66", "SEU",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=SEU");
		this.add("\u4e0a\u6d77\u4ea4\u901a\u5927\u5b66", "SJTU",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=SJTU");
		this.add("\u82cf\u5dde\u5927\u5b66", "SUDA",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=SUDA");
		this.add("\u897f\u5357\u4ea4\u901a\u5927\u5b66", "SWJTU",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=SWJTU");
		this.add("\u6e05\u534e\u5927\u5b66", "THU",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=THU");
		this.add("\u5929\u6d25\u5927\u5b66", "TJU",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=TJU");
		this.add("\u540c\u6d4e\u5927\u5b66", "TongJi",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=TongJi");
		this.add("\u7535\u5b50\u79d1\u6280\u5927\u5b66", "UESTC",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=UESTC");
		this.add("\u9a6c\u91cc\u5170\u5927\u5b66", "UMD",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=UMD");
		this.add("\u5317\u4eac\u79d1\u6280\u5927\u5b66", "USTB",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=USTB");
		this.add("\u4e2d\u56fd\u79d1\u5b66\u6280\u672f\u5927\u5b66", "USTC",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=USTC");
		this.add("\u6b66\u6c49\u5927\u5b66", "WHU",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=WHU");
		this.add("\u897f\u5b89\u7535\u5b50\u79d1\u6280\u5927\u5b66", "XiDian",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=XiDian");
		this.add("\u897f\u5b89\u4ea4\u901a\u5927\u5b66", "XJTU",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=XJTU");
		this.add("\u53a6\u95e8\u5927\u5b66", "XMU",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=XMU");
		this.add("\u6d59\u6c5f\u5927\u5b66", "ZJU",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=ZJU");
		this.add("\u4e2d\u5c71\u5927\u5b66", "ZSU",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=ZSU");
		categoryPagePostListArray.add(new ArrayList(new HashSet( categoryPagePostList)));
		categoryPagePostList.clear();

		// Section 8, Xiang Li Xiang Qing 		
		this.add("\u7696\u98ce\u5fbd\u97f5", "Anhui",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Anhui");
		this.add("\u6211\u7231\u5317\u4eac\u5929\u5b89\u95e8", "Beijing",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Beijing");
		this.add("\u4e00\u76c5\u4e24\u4ef6", "Cantonese",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Cantonese");
		this.add("\u5df4\u5c71\u8700\u6c34", "ChuanYu",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=ChuanYu");
		this.add("\u516b\u95fd\u5927\u5730", "Fujian",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Fujian");
		this.add("\u4f60\u597d\u6d77\u5357", "HAINAN",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=HAINAN");
		this.add("\u957f\u57ce\u5185\u5916", "Hebei",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Hebei");
		this.add("\u4e2d\u539f", "Henan",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Henan");
		this.add("\u4e5d\u5934\u9e1f", "Hubei",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Hubei");
		this.add("\u4e09\u6e58\u56db\u6c34", "HuNan",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=HuNan");
		this.add("\u6700\u5fc6\u662f\u6c5f\u5357", "Jiangnan",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Jiangnan");
		this.add("\u6c5f\u82cf\u83dc\u7c7d", "Jiangsu",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Jiangsu");
		this.add("\u6c5f\u5357\u897f\u9053", "Jiangxi",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Jiangxi");
		this.add("\u767d\u5c71\u9ed1\u6c34", "NorthEast",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=NorthEast");
		this.add("\u4e09\u79e6", "Shaanxi",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Shaanxi");
		this.add("\u9f50\u9c81\u9752\u672a\u4e86", "Shandong",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Shandong");
		this.add("\u4e0a\u6d77\u98ce\u60c5", "Shanghai",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Shanghai");
		this.add("\u60c5\u7cfb\u4e09\u664b", "Shanxi",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Shanxi");
		this.add("\u897f\u5357", "Southwest",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Southwest");
		this.add("\u72d7\u4e0d\u7406\u5341\u516b\u8857\u8033\u6735\u773c", "Tianjin",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Tianjin");
		this.add("\u897f\u5317\u671b\u5c04\u5929\u72fc", "Xibei",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Xibei");
		this.add("\u6d59\u6c5f", "Zhejiang",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Zhejiang");
		categoryPagePostListArray.add(new ArrayList(new HashSet( categoryPagePostList)));
		categoryPagePostList.clear();

		// Section 9, Dian Nao Wang Luo 		
		this.add("\u5bb6\u6709\u82f9\u679c", "Apple",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Apple");
		this.add("\u7f51\u7ad9\u5efa\u8bbe", "BuildingWeb",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=BuildingWeb");
		this.add("\u7535\u8111\u56fe\u5f62\u5904\u7406", "ComputerGraphics",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=ComputerGraphics");
		this.add("\u8ba1\u7b97\u673a\u79d1\u5b66", "CS",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=CS");
		this.add("\u6570\u636e\u5e93", "Database",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Database");
		this.add("\u7a97\u53e3\u91cc\u7684\u98ce\u666f", "DotNet",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=DotNet");
		this.add("\u70ed\u95e8\u7f51\u7edc\u6280\u672f", "EmergingNetworking",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=EmergingNetworking");
		this.add("\u95ea\u5ba2\u4e00\u65cf", "Flash",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Flash");
		this.add("\u865a\u62df\u4eba\u751f", "Game",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Game");
		this.add("\u8ba1\u7b97\u673a\u786c\u4ef6", "Hardware",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Hardware");
		this.add("\u6709\u7f18\u5343\u91cc\u4e00\u7ebf\u7275", "Internet",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Internet");
		this.add("\u722a\u54c7\u5a07\u5a03", "Java",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Java");
		this.add("Linux \u64cd\u4f5c\u7cfb\u7edf", "Linux",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Linux");
		this.add("\u638c\u4e2d\u5b9d", "PDA",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=PDA");
		this.add("\u8475\u82b1\u5b9d\u5178", "Programming",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Programming");
		this.add("\u79d1\u6280\u65b0\u95fb", "ScitechNews",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=ScitechNews");
		this.add("\u7cfb\u7edf\u5b89\u5168", "Security",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Security");
		this.add("\u8f6f\u4ef6\u4e16\u754c", "Software",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Software");
		this.add("TeX\u7535\u5b50\u6392\u7248\u7cfb\u7edf", "TeX",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=TeX");
		this.add("\u89c6\u9891\u6e38\u620f", "TVGame",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=TVGame");
		this.add("\u566b\u5401\u516e\uff0c\u5371\u4e4e\u9ad8\u54c9", "Unix",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Unix");
		this.add("\u770b\u5f97\u89c1\u98ce\u666f\u7684\u7a97\u53e3", "Windows",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Windows");
		this.add("WWW\u660e\u65e5\u4e4b\u661f", "XML",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=XML");
		categoryPagePostListArray.add(new ArrayList(new HashSet( categoryPagePostList)));
		categoryPagePostList.clear();

		// Section 10, Xue Shu Xue Ke 		
		this.add("\u4f1a\u8ba1\u5ba1\u8ba1", "Accounting",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Accounting");
		this.add("\u7cbe\u7b97", "Actuary",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Actuary");
		this.add("\u4eba\u7c7b\u5b66\u548c\u8bed\u8a00\u5b66", "AnthroLing",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=AnthroLing");
		this.add("\u5929\u6587", "Astronomy",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Astronomy");
		this.add("\u822a\u7a7a\u822a\u5929", "Aviation",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Aviation");
		this.add("\u751f\u7269\u5b66", "Biology",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Biology");
		this.add("\u5546\u5b66\u9662", "Business",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Business");
		this.add("\u5316\u5b66\u5de5\u7a0b", "ChemEng",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=ChemEng");
		this.add("\u5316\u5b66", "Chemistry",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Chemistry");
		this.add("\u4e2d\u56fd\u7814\u7a76", "China",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=China");
		this.add("\u4e2d\u533b", "ChineseMed",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=ChineseMed");
		this.add("\u571f\u6728\u5de5\u7a0b", "CivilEngineering",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=CivilEngineering");
		this.add("\u79d1\u5b66\u8ba1\u7b97", "Computation",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Computation");
		this.add("\u7ecf\u6d4e", "Economics",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Economics");
		this.add("\u6559\u80b2\u5b66", "Education",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Education");
		this.add("\u7535\u5b50\u5de5\u7a0b", "EE",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=EE");
		this.add("\u5de5\u7a0b", "Engineering",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Engineering");
		this.add("\u73af\u5883\u79d1\u5b66\u4e0e\u5de5\u7a0b", "Environmental",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Environmental");
		this.add("\u5730\u7403\u4e0e\u7a7a\u95f4\u79d1\u5b66", "GeoSpace",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=GeoSpace");
		this.add("\u5f8b\u5e08\u4e8b\u52a1\u6240", "Law",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Law");
		this.add("\u9ad8\u5206\u5b50", "Macromolecules",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Macromolecules");
		this.add("\u6570\u5b66", "Mathematics",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Mathematics");
		this.add("\u673a\u68b0\u5de5\u7a0b", "ME",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=ME");
		this.add("\u533b\u5b66\u804c\u4e1a", "MedicalCareer",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=MedicalCareer");
		this.add("\u7eb3\u7c73\u79d1\u6280", "NanoST",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=NanoST");
		this.add("\u62a4\u58eb", "Nurse",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Nurse");
		this.add("\u5236\u836f", "Pharmaceutical",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Pharmaceutical");
		this.add("\u836f\u5b66", "Pharmacy",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Pharmacy");
		this.add("\u7269\u7406\u5b66", "Physics",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Physics");
		this.add("\u653f\u6cbb\u5b66", "PoliticalScience",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=PoliticalScience");
		this.add("\u5fc3\u7406\u5b66", "Psychology",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Psychology");
		this.add("\u91d1\u878d\u5de5\u7a0b", "Quant",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Quant");
		this.add("\u81ea\u7136\u79d1\u5b66", "Science",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Science");
		this.add("\u793e\u4f1a\u5b66", "Sociology",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Sociology");
		this.add("\u7edf\u8ba1", "Statistics",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Statistics");
		categoryPagePostListArray.add(new ArrayList(new HashSet( categoryPagePostList)));
		categoryPagePostList.clear();

		// Section 12, Ben Zhan Xi Tong 		
		this.add("\u672c\u7ad9\u5341\u5468\u5e74\u7eaa\u5ff5", "Anniversary",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Anniversary");
		this.add("\u91cd\u8981\u901a\u77e5", "Announcement",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Announcement");
		this.add("\u7533\u8bf7\u4ff1\u4e50\u90e8\u677f", "ApplyClub",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=ApplyClub");
		this.add("\u677f\u4e3b\u4e4b\u5bb6", "board",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=board");
		this.add("\u672c\u7ad9\u667a\u56ca\u56e2", "BrainTrust",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=BrainTrust");
		this.add("\u672a\u540d\u6587\u6458", "Collection",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Collection");
		this.add("\u6295\u8bc9", "Complain",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Complain");
		this.add("\u672a\u540d\u535a\u5ba2", "Mitbbs_Blog",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Mitbbs_Blog");
		this.add("\u5efa\u8bbe\u65b0\u7ad9", "NewBBS",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=NewBBS");
		this.add("\u6d41\u8a00\u677f", "notepad",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=notepad");
		this.add("\u7cfb\u7edf\u901a\u77e5", "Notice",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Notice");
		this.add("\u63a8\u8350\u6587\u7ae0", "Recommend",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=Recommend");
		this.add("\u7ad9\u957f\u7684\u5de5\u4f5c\u5ba4", "sysop",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=sysop");
		this.add("\u6d4b\u8bd5", "test",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=test");
		this.add("\u7f6e\u9876\u6587\u7ae0", "TopArticle",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=TopArticle");
		this.add("\u672c\u7ad9\u5404\u9879\u6295\u7968\u4e0e\u7ed3\u679c", "vote",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=vote");
		this.add("\u4f2a\u5e01\u4e2d\u5fc3", "WBCenter",
		"http://www.mitbbs.com/mobile/mbbsdoc.php?board=WBCenter");
		categoryPagePostListArray.add(new ArrayList(new HashSet( categoryPagePostList)));
		categoryPagePostList.clear();
		
	}

	public void PopupData() {

	}

	public String[] getCategoryName() {
		return this.categoryName;
	}

	public HashMap<String, String> get(int Position) {
		return categoryPagePostList.get(Position);
	}

	public ArrayList<HashMap<String, String>> getCategoryPagePostList() {
		return categoryPagePostList;
	}

	public void setCategoryPagePostList(
			ArrayList<HashMap<String, String>> inCategoryPagePostList) {
		categoryPagePostList = inCategoryPagePostList;
	}

	public void add(String TitleCN, String TitleEN, String Url) {
		HashMap<String, String> categoryPagePost = new HashMap<String, String>();
		categoryPagePost.put("TitleCN", TitleCN);
		categoryPagePost.put("TitleEN", TitleEN);
		categoryPagePost.put("Url", Url);
		categoryPagePostList.add(categoryPagePost);
		
		Log.i(TAG,"added one item");
	}

	public void add(String TitleCN, String TitleEN, URL Url) {
		this.add(TitleCN, TitleEN, Url.toString());
	}

}
