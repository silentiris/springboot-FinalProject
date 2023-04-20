# springboot-FinalProject
## 2022科协后端大作业
## 春晚节目单
- Host : localhost
- Port : 8077
## **api**
### 获取所有节目
**URL :** /get/programList
**Param :**
参数名称|参数类型|描述
---|---|---
pageNum|Integer|页码

**Response :**

```JSON
{
    "code": "00000",
    "message": "请求正常",
    "data": {
        "programResults": [
            {
                "id": 1,
                "typeName": "戏曲",
                "name": "三顾茅庐",
                "view": "主打就是一个颠覆三观！",
                "actorList": "张飞，周瑜，诸葛亮"
            },
            {
                "id": 2,
                "typeName": "戏曲",
                "name": "三打白骨精",
                "view": "真好看",
                "actorList": "猫猫，鲨鲨"
            }
        ]
    }
}
```
 
### 按条件搜索节目

**URL :** /get/search

**Param :**

**参数名称**|**参数类型**|**描述**
---|---|---
type|Integer|节目类型
num|Integer|演员人数
name|String|节目名称

**Response :**

```JSON
{
    "code": "00000",
    "message": "请求正常",
    "data": {
        "programSearchResults": [
            {
                "id": 1,
                "typeName": "戏曲",
                "name": "三顾茅庐",
                "view": "主打就是一个颠覆三观！",
                "actorList": "张飞，周瑜，诸葛亮",
                "num": 3
            },
            {
                "id": 2,
                "typeName": "戏曲",
                "name": "三打白骨精",
                "view": "真好看",
                "actorList": "猫猫，鲨鲨",
                "num": 2
            }
        ]
    }
}
```

**特殊要求 :** 检索条件可以全选也可以部分选

### 新增一个节目
**URL :** /add/program

**Body :**

```JSON
{
    "type": "戏曲",    
    "name": "三顾茅庐",   
    "point": "主打就是一个颠覆三观！",   
    "actors": "张飞，周瑜，诸葛亮"   
}
```

**Response :**

```JSON
{
    "code": "00000",
    "message": "添加成功"
}
```

**特殊要求 :** 多个演员使用中文逗号隔开

### 删除一个节目
**URL :** /delete/program
**Body :**

```JSON
{
    "id": 12   
}
```

**Response :**

```JSON
{
    "code": "00000",
    "message": "删除成功"
}
```

### 更新一个节目

**URL :** /update/program

**Body :**

```JSON
{
    "id": 12,  
    "type": "戏曲",   
    "name": "三顾茅庐",   
    "point": "主打就是一个颠覆三观！",   
    "actors": "张飞，周瑜，诸葛亮"   
}
```

**Response :**

```JSON
{
    "code": "00000",
    "message": "更新成功"
}
```

**特殊要求 :** 不更新的信息也需要传入原本的数据作为参数
