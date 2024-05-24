<template>
  <view class="container">
	  <!-- 顶部  图片及标题-->
    <view class="top">
    	<u--image src="../../static/login/980.png" width="100%" height="300px"></u--image>
    	<!-- <image src="../../static/login/980.png" mode="widthFix" style="width: 100%;"></image> -->
    	<!-- <text class="title" style="color: #ffffff; ">智慧农业系统</text> -->
    	<view class="headline">
    		<u--text type="primary" text="智慧农业系统" size=30 align="center"></u--text>
    	</view>
    </view> 
	<!--中下部分-->
    <view class="buttom">
      <view class="main">
        <view class="textStyle">
          <view :class="navId=='login'?'active':'unactive'" @click="itemclick('login')">登录</view>
          <view :class="navId=='register'?'active':'unactive'" @click="itemclick('register')">注册</view>
        </view>
        <!-- 登录 -->
        <view class="operation" v-show="navId=='login'">
          <view class="items">
			  <u--input placeholder="请输入用户名" border="none" v-model="user.username" prefixIcon="man-add"
			  	prefixIconStyle="font-size: 22px;color: #909399"></u--input>
            <!-- <image src="../../static/login/denglu.png" mode="widthFix" style="width: 40rpx;margin-right:16rpx ;"></image>
            <u-input class="uni-input" focus placeholder="请输入用户名" v-model="user.username"/> -->
          </view>
          <view class="items">
			  <u--input placeholder="请输入密码" border="none" v-model="user.password" prefixIcon="lock"
			  	prefixIconStyle="font-size: 22px;color: #909399"></u--input>
            <!-- <image src="../../static/login/lock.png" mode="widthFix" style="width: 40rpx;margin-right:16rpx ;"></image>
            <u-input class="uni-input" focus placeholder="请输入密码" v-model="user.password" type="password"/> -->
          </view>
		  <u-button class="custom-button" @click="login()">
		  	<text class="custom-text">确认</text>
		  </u-button>
          <!-- <view class="flex-col justify-start button section_2" @click="login()">
            <text class="font text_4 text_12 pos_3">确认</text>
          </view> -->
		  <view class="forgetpsw" @click="forgetpassword()">忘记密码</view>
        </view>
		
        <!-- 注册 -->
        <view class="operation" v-show="navId=='register'">
          <view class="items">
			  <u--input placeholder="请输入用户名" border="none" v-model="user.username" prefixIcon="man-add"
			  	prefixIconStyle="font-size: 22px;color: #909399"></u--input>
            <!-- <image src="../../static/login/denglu.png" mode="widthFix" style="width: 40rpx;margin-right:16rpx ;"></image>
            <input class="uni-input" focus placeholder="请输入用户名" v-model="user.username" /> -->
          </view>
		  <view class="items">
			  <u--input placeholder="请输入姓名" border="none" v-model="user.name" prefixIcon="man-add"
			  	prefixIconStyle="font-size: 22px;color: #909399"></u--input>
		 <!--  <image src="../../static/login/姓名.png" mode="widthFix" style="width: 40rpx;margin-right:16rpx ;"></image>
		    <input class="uni-input" focus placeholder="请输入姓名" v-model="user.name" /> -->
		  </view>
		  <view class="items">
			  <u--input placeholder="请输入密码" border="none" v-model="user.password" prefixIcon="man-add"
			  	prefixIconStyle="font-size: 22px;color: #909399"></u--input>
		    <!-- <image src="../../static/login/lock.png" mode="widthFix" style="width: 40rpx;margin-right:16rpx ;"></image>
		    <u-input class="uni-input" focus placeholder="请输入密码" v-model="user.password" type="password"/> -->
		  </view>
		  <view class="items">
			  <u--input placeholder="请确认密码" border="none" v-model="makesure" prefixIcon="man-add"
			  	prefixIconStyle="font-size: 22px;color: #909399"></u--input>
		    <!-- <image src="../../static/login/lock.png" mode="widthFix" style="width: 40rpx;margin-right:16rpx ;"></image>
		    <u-input class="uni-input" focus placeholder="请确认密码" v-model="makesure" type="password"/> -->
		  </view>
		  <view class="items">
			  <u--input placeholder="请输入密保问题" border="none" v-model="user.securityquestion" prefixIcon="man-add"
			  	prefixIconStyle="font-size: 22px;color: #909399"></u--input>
		    <!-- <image src="../../static/login/密保 (1).png" mode="widthFix" style="width: 40rpx;margin-right:16rpx ;"></image>
		    <input class="uni-input" focus placeholder="请输入密保问题" v-model="user.securityquestion" /> -->
		  </view>
		  <view class="items">
			  <u--input placeholder="请输入答案" border="none" v-model="user.securityanswer" prefixIcon="man-add"
			  	prefixIconStyle="font-size: 22px;color: #909399"></u--input>
	      <!-- <image src="../../static/login/icon_密保.png" mode="widthFix" style="width: 40rpx;margin-right:16rpx ;"></image>
		    <input class="uni-input" focus placeholder="请输入答案" v-model="user.securityanswer" /> -->
		  </view>
		  <view class="items">
			  <u--input placeholder="请输入农田号码" border="none" v-model="user.nongtian" prefixIcon="man-add"
			  	prefixIconStyle="font-size: 22px;color: #909399"></u--input>
		    <!-- <image src="../../static/login/icon_密保.png" mode="widthFix" style="width: 40rpx;margin-right:16rpx ;"></image>
		    <input class="uni-input" focus placeholder="请输入农田号码" v-model="user.nongtian" /> -->
		  </view>
		  <u-button class="custom-button" @click="register()">
		  	<text class="custom-text">注册</text>
		  </u-button>
			 <!-- <view class="flex-col justify-start button section_2" @click="register()">
			    <text class="font text_4 text_12 pos_3">注册</text>
			  </view> -->
		  </view>
        </view>
      </view>
    </view>
  </view>
</template>

<script>
  export default {
    data() {
      return {
        navId: 'login',
		makesure:'',
        user:{
			username:'',
			name:'',
			password:'',
			securityquestion:'',
			securityanswer:'',
			nongtian:'',
			
		},
        token: "",
      };
    },
	onShow() {
		
	},
	onLaunch() {
		
	},
	onLoad() {
		
	},
    methods: {
      //切换登录or注册
      itemclick(value) {
        this.navId = value
		this.user.username = ''
		this.user.password = ''
      },
      //登录
      login() {
        uni.request({
        	url:"http://127.0.0.1:4523/m1/4449912-4095843-default/login",
        	data:this.user,
        	method:'POST',
        	success: (res) => {
        		//if(res.data.code*1 == 200){
				if(res.data.status==1){
        			this.$u.toast('登录成功')
        			uni.setStorageSync("user",this.user)
        			uni.navigateTo({
        				url:'/pages/sy'
        			})
        		}else{
        			this.$u.toast('登录失败，请重新登录')
        		}
        	}
        })
      },
      //用户协议
      userText() {
        // 跳转
      },
      //隐私协议
      register(){
		if(this.user.username.length>8){
			this.$u.toast('用户名不宜过长')
			return
		}else if(this.user.username.length<3){
			this.$u.toast('用户名不宜过短')
			return
		}else if(this.user.password.length<3){
			this.$u.toast('密码不宜过短')
			return
		}else if(this.user.password.length>10){
			this.$u.toast('密码不宜过长')
			return
		}else if(this.user.name.length == 0){
			this.$u.toast('姓名不能为空')
			return
		}else if(this.user.securityquestion.length == 0){
			this.$u.toast('密保问题不能为空')
			return
		}else if(this.user.securityanswer.length == 0){
			this.$u.toast('密保答案不能为空')
			return
		}else if(this.makesure != this.user.password){
			this.$u.toast('两次输入的密码不一致')
			return
		}else if(this.user.nongtian.length == 0){
			this.$u.toast('农田号码不能为空')
			return	
			
			
		}else{
			uni.request({
				url:"http://127.0.0.1:4523/m1/4449912-4095843-default/register",
				data:this.user,
				method:'POST',
				success: (res) => {
					//if(response.data.code*1 == 200){
					if(res.data.status==1){
						this.navId = 'login'
					}else{
						this.$u.toast("注册失败，请再次尝试")
					}
				}
			})
			
		}  
	  },
	  forgetpassword(){
	  	uni.navigateTo({
	  		url:'/pages/forget/forget'
	  	})
	  }
    }
  }
</script>

<style scoped lang="scss">
	.buttom {
		width: 100%;
		display: flex;
		justify-content: center;
	
		.main {
			position: relative;
			width: 670rpx;
			height: 650rpx;
			background-color: #ffffff;
			box-shadow: 0px 0px 9px 0px rgba(10, 53, 74, 0.19);
			border-radius: 40rpx;
			margin-top: -150rpx;
		}
	}
	
	.textStyle {
		display: flex;           /* 使用flex布局 */
		justify-content: center; /* 水平居中对齐 */
		width: 100%;             /* 容器宽度设为100% */
		padding: 10px 0;         /* 上下边距，根据需要调整 */
	}
	.textStyle view {
	  flex: 1;                 /* 子元素占据相等的空间 */
	  display: flex;
	  justify-content: center; /* 子元素内部水平居中 */
	  align-items: center;     /* 子元素内部垂直居中 */
	  height: 60rpx;           /* 根据需要设置高度 */
	  margin: 0 10rpx;         /* 左右边距，防止元素之间粘连 */
	  /* 其他样式... */
	}
	
	.textStyle view:first-child {
	  margin-left: 0;         /* 移除第一个元素的左边距 */
	}
	
	.textStyle view:last-child {
	  margin-right: 0;        /* 移除最后一个元素的右边距 */
	}
	
	/* 激活状态下的选项卡样式 */
	.textStyle view.active {
	  /* 激活状态下的样式，例如改变背景色或文字颜色 */
	}
	/* 按钮样式 */
	.custom-button {
		position: relative;
		align-self: center;
		margin: 10px;
		box-shadow: 0rpx 14rpx 34rpx #7033ff33;
		background-image: linear-gradient(89.99999999999999deg, #55aaff 0%, #5a54ff 100%);
		border-radius: 16rpx;
		width: 510rpx;
		height: 96rpx;
		text-align: center;
	}
	
	/* 文本样式 */
	.custom-text {
		position: absolute;
		left: 50%;
		top: 50%;
		transform: translate(-50%, -50%);
		text-transform: uppercase;
		color: #ffffff;
		font-size: 20px;
	}
	
	
	
	// .box2 {
	//   display: flex;           /* 使用flex布局 */
	//   justify-content: center; /* 水平居中对齐 */
	//   width: 100%;             /* 容器宽度设为100% */
	//   padding: 10px 0;         /* 上下边距，根据需要调整 */
	// }
	
	// .box2 view {
	//   flex: 1;                 /* 子元素占据相等的空间 */
	//   display: flex;
	//   justify-content: center; /* 子元素内部水平居中 */
	//   align-items: center;     /* 子元素内部垂直居中 */
	//   height: 60rpx;           /* 根据需要设置高度 */
	//   margin: 0 10rpx;         /* 左右边距，防止元素之间粘连 */
	//   /* 其他样式... */
	// }
	
	// .box2 view:first-child {
	//   margin-left: 0;         /* 移除第一个元素的左边距 */
	// }
	
	// .box2 view:last-child {
	//   margin-right: 0;        /* 移除最后一个元素的右边距 */
	// }
	
	// /* 激活状态下的选项卡样式 */
	// .box2 view.active {
	//   /* 激活状态下的样式，例如改变背景色或文字颜色 */
	// }
	
	
	.bt{
		flex: auto;
				  display: flex;
				  flex-direction: column;
				  justify-content: center;
				  align-items: center;
	}
	@import "@/css/system.scss";  
</style>