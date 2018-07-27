# 1.1 登陆相关

## 1.1.1 获取openid

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

## 1.1.2 添加用户

- POST /singup
- payload :
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
```json
{
	"code" : 0,
	"userId" : 12
}
```
## 1.1.3 获取用户信息

- GET /info/{userId}
- return :
```json
{
	"wechatName" : "改个名字太急人了",
	"gender" : "男",
	"profileImg" : "http://baidu.com",
	"name" : "陈",
	"telNmubner" : "123123",
	"addr" : "新校区"
}
```

# 1.2 轮播图设置

## 1.2.1 获取轮播图

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

# 1.3 图片相关

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
{
	"data": [
        {
            "imgUrl" : "http://baidu.com"
        },
        {
            "imgUrl" : "http://google.com"
        }
    ]
}
```

- return :
```json
{
	"code" : 0,
	"data" : true
}
```

## 1.3.3 获取图片

- GET /img/{itemId}
- paylod : 
	- ietmId : 当前商品的ID
	//根据添加的时间升序排序
- return :
```json
{
	"code" : 0,
	"data" : [
		{
			"imgUrl" : "http://baidu.com"
		},
		{
			"imgUrl" : "http://baidu.com"
		},
	]
}
```




# 1.4 商品相关

## 1.4.1 发布商品

- POST /item
- payload ： 
	- name ：商品名
	- price ： 价格
	- sortId ： 分类id
	- content ： 内容
	- publishId : 发布者ID
	- status : 商品状态   0 审核未通过|1 审核通过|2 已出售|3 已关闭

```json
{
	"name" : "商品1",
	"price" : 123,
	"sortId" : 1,
	"content" : "balabalabalablab",
	"publishId" : 123,
	"status" : 1
}

```

- return :

```json
{
	"code" : 0,
	"item_id" : 123
}
```

## 1.4.2 获取商品

- GET /item/{sortId}
- sortId 为空返回全部商品，否则返回对应分类商品
- return ： 
	- itmId ：商品ID
	- name ：商品名
	- price ： 价格
	- sortId ： 分类id
	- content ： 内容
	- publishId : 发布者ID
    - createTime : 创建时间
    - view ：浏览人数
	- status : 商品状态   0 审核未通过|1 审核通过|2 已出售|3 已关闭

```json
{
	"code" : 0,
	"data" : [
		{
		"itmId" : 123,
		"name" : "商品1",
		"price" : 123,
		"sortId" : 123,
		"content" : "asdasd",
		"publishId" : 123,
        "createTime" : "2010-10-10",
        "view" : 100,
		"status" : 1
	},
	{
		"itmId" : 123,
		"name" : "商品1",
		"price" : 123,
		"sortId" : 123,
		"content" : "asdasd",
		"publishId" : 123,
        "createTime" : "2010-10-10",
        "view" : 100,
		"status" : 1
	}	
	]
	
}

```

# 1.5 分类

## 1.5.1 获取分类

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
		"itemId" : "bababba",
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
