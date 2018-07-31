# 1.1 登陆相关

## 1.1.1 获取openid [完成]

- POST /openid
- payload : 
	- code : 微信登陆code
```json
{
	"code" : "XXXXXXXX"
}
```

- return :
	- openid : 微信用户唯一标识
	- sessionKey :

```json 
{
	"code" : 0,
	"data" : {
		"openId" : "asdasd",
		"sessionKey" : "asdsa"
	}
	
}
```

## 1.1.2 添加用户 [完成]

- POST /singup
- payload : （允许为空）
	- name : 真实姓名
	- telNumber : 手机号码
	- addr : 收货地址

```json
{
	"wechatName" : "改个名字太急人了",
	"gender" : "男",
	"profileImg" : "http://baidu.com",
	"name" : "陈",
	"telNumber" : "123123",
	"address" : "新校区",
	"openId" : "asdasd",
	"sessionKey" : "asdsa"
}
```

- return :
传参注册成功
```json
{
	"code" : 0,
	"userId" : 12
}
```

传空已经被注册
```json
{
    "code": 2,
    "data": {
        "message": "欢迎回来!",
        "userId": 100045
    }
}
```

传空未被注册
```json
{
    "code": 0,
    "data": "请重新登陆"
}
```



## 1.1.3 获取用户信息 [完成]

- GET /info/{userId}
- return :
```json
{
        "telNumber": "123123",
        "address": "新校区",
        "gender": "男",
        "sessionKey": "asdsa",
        "createTime": "2018-07-28 00:00:00.0",
        "openId": "oFlyK5dL0fSurY_d4g5Dzi2X6UKI",
        "name": "陈",
        "wechatName": "玳玳花",
        "profileImg": "http://baidu.com",
        "lastEditTime": "2018-07-28 00:00:00.0",
        "userId": 100046
}
```

# 1.2 轮播图设置

## 1.2.1 获取轮图 [完成]

- GET /pic
- return:
	* index : 图片序号
	* name : 图片名称
	* url ： 图片地址

```json
{
    "code": 0,
    "data": [
        {
            "picId" : 123,
            "name": "图片1",
            "url": "http://www.baidu.com"
        },
        {
            "picId" : 123,
            "name": "图片2",
            "url": "http://www.baidu.com"
        }
    ]
}

```

## 1.2.2 新增轮播图

- POST /pic
- payload :

```json
{
    "name": "1",
    "url": "http://123",
    "enable": 1
}
```

- return :

```json
{
    "code": 0,
    "picId" : 123
}
```

## 1.2.3 修改轮播图

- PUT /pic
- payload :

```json
{
    "picId": "1",
    "name" : "bala",
    "url" : "http://123",
	"enable" : 0
}
```

- return :

```json
{
    "code": 0,
    "data": true
}
```

## 1.2.4 删除轮播图

- DELETE /pic/{systemId}
- return :

```json
{
    "code": 0,
    "data": true
}
```

# 1.3 图片相关 [完成]


## 1.3.1 获取uptoken 
- GET /uptoken
- return : 
```json
{
	"code" : 0,
	"uptoken" : "123"
}
```

## 1.3.2 上传图片

- POST /img
- payload :

```json
[
    {
		"itemId" : 1,
        "imgUrl" : "http://baidu.com"
    },
    {
		"itemId" : 1,
        "imgUrl" : "http://google.com"
    }
]
```

- return :
```json
{
	"code" : 0,
	"data" : [
		{
			"imgId" :1
		},
		{
			"imgId" :2
		}
	]
}
```

## 1.3.3 获取商品图片

- GET /img/{itemId}
- payload : 
	- itemId : 当前商品的ID
	//根据添加的时间升序排序
- return :
```json
{
    "code": 0,
    "data": [
        {
            "imgId": 1,
            "imgUrl": "http://google.com",
            "itemId": 1
        },
        {
            "imgId": 1,
            "imgUrl": "http://baidu.com",
            "itemId": 1
        },
        {
            "imgId": 1,
            "imgUrl": "http://google.com",
            "itemId": 1
        },
        {
            "imgId": 1,
            "imgUrl": "http://baidu.com",
            "itemId": 1
        }
    ]
}
```




# 1.4 商品相关 [完成]

## 1.4.1 发布商品

- POST /item
- payload ： 
	- name ：商品名
	- price ： 价格
	- sortId ： 分类id
	- content ： 内容
	- views : 查看人数
	- publishId : 发布者ID
	- status : 商品状态   0 审核未通过|1 审核通过|2 已出售|3 已关闭

```json
{
	"name" : "商品1",
	"price" : 123,
	"sortId" : 1,
	"content" : "balabalabalablab",
	"publishId" : 123,
	"views" : 1,
	"status" : 1
}

```

- return :

```json
{
	"code" : 0,
	"data" : 123
}
```

## 1.4.2 获取分类商品

- GET /item/?sortId=
- sortId 为空返回全部商品，否则返回对应分类商品
- return ： 
	- itmId ：商品ID
	- name ：商品名
	- price ： 价格
	- sortId : 123
	- publishId : 发布者ID
    - createTime : 创建时间
    - views ：浏览人数

```json
{
	"code" : 0,
	"data" : [
		{
		"itmId" : 123,
		"name" : "商品1",
		"price" : 123,
		"sortId" : 123,
		"publishId" : 123,
        "createTime" : "2010-10-10",
        "views" : 100
	},
	{
		"itmId" : 123,
		"name" : "商品1",
		"price" : 123,
		"sortId" : 123,
		"publishId" : 123,
        "createTime" : "2010-10-10",
        "views" : 100
	}	
	]
	
}

```

## 1.4.3 获取具体商品
- GET /item?itemId=
- payload :
	itemId : 商品Id

- return :
- itmId ：商品ID
	- name ：商品名
	- price ： 价格
	- sortId : 123
	- publishId : 发布者ID
    - createTime : 创建时间
    - view ：浏览人数
	- status : 商品状态   0 审核未通过|1 审核通过|2 已出售|3 已关闭
```json
{
	"code" : 0,
	"data" : {
		"itmId" : 123,
		"name" : "商品1",
		"price" : 123,
		"sortId" : 123,
		"content" : "asdasd",
		"publishId" : 123,
        "createTime" : "2010-10-10",
        "views" : 100,
		"status" : 1
	}
}
```

# 1.5 分类

## 1.5.1 获取分类 [完成]

- GET /sort
- return :

```json
{
	"code" : 0,
	"data" : [
		{
			"sortId" : 1,
			"sortIndex" : 1,
			"sortName" : "手机数码"
		},
		{
			"sortId" : 2,
            "sortIndex" : 2,
			"sortName" : "二手书籍"
		},
	]
}
```


---- 暂停-----

# 1.5 评论

## 1.5.1 发布评论

- POST /comment
- payload ：
	- content ： 评论内容

```json
{
	"content" : "bababba"
}
	
```

- return :

```json
{
	"code" : 0,
	"data" : true
}
```

## 1.5.2 获取评论

- GET /comment/{itemId}
- return ：
	- systemId ：评论id
	- userId ：用户id
	- content ：评论内容

```json
{
	"code" : 0,
	"data" : [
		{
			"systemId" : 111,
			"userId" : 111,
			"content" : "dhfshfs"
		
		}
		{
			"systemId" : 111,
			"userId" : 111,
			"content" : "dhfshfs"
		
		}
	]
}
```

# 1.6 收藏

## 1.6.1 添加收藏

- POST /star
- payload ：
	- itemId ： 收藏商品id

```json
{
	"data" : 
	{
		"itemId" : "bababba"
	}		
}
	
```

- return :

```json
{
	"code" : 0,
	"data" : true
}
```

## 1.6.2 获取收藏

- GET /star/{userId}
- return ：
	- systemId ：收藏id
	- userId ：用户id
	- itemId ：商品id

```json
{
	"code" : 0,
	"data" : [
		{
			"systemId" : 111,
			"userId" : 111,
			"itemId" : 111		
		}
		{
			"systemId" : 111,
			"userId" : 111,
			"itemId" : 111			
		}
	]
}
```

## 1.6.3 取消收藏
- DELETE /delete/{systemID}
- return ：

```json
{
	"code" : 0,
	"data" : true
}
```
