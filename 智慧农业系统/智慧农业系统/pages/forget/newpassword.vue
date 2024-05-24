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
			<!-- 中间圆框-->
			<view class="main">
				<!--文本：找回密码-->
				<view class="mimatext">
					<view>设置新密码</view>
				</view>
				<!-- 输入框及按钮-->
				<view class="operation">
					<!--输入框背景 -->
					<view class="items">
						<u--input placeholder="请输入新密码" border="none" v-model="newPassword" prefixIcon="lock"
							prefixIconStyle="font-size: 22px;color: #909399"></u--input>
						<!-- <image src="../../static/login/lock.png" mode="widthFix"
							style="width: 40rpx;margin-right:16rpx;"></image>
						<input class="uni-input" focus placeholder="请输入新密码" v-model="newPassword" /> -->
					</view>
					<view class="items">
						<u--input placeholder="确认密码" border="none" v-model="confirmPassword" prefixIcon="lock-fill"
							prefixIconStyle="font-size: 22px;color: #909399"></u--input>
						<!-- <image src="../../static/login/lock.png" mode="widthFix"
							style="width: 40rpx;margin-right:16rpx;"></image>
						<input class="uni-input" focus placeholder="请再次输入新密码" v-model="confirmPassword" /> -->
					</view>
					<u-button class="custom-button" @click="submit()">
						<text class="custom-text">提交</text>
					</u-button>
					<!-- <view class="flex-col justify-start button section_2" @click="submit">
						<text class="font text_4 text_12 pos_3">提交</text>
					</view> -->
					<u-button class="custom-button" @click="goback()">
						<text class="custom-text">返回登录</text>
					</u-button>
					<!-- <view class="flex-col justify-start button section_2" @click="goback">
						<text class="font text_4 text_12 pos_3">返回登录</text>
					</view> -->
				</view>
			</view>
		</view>
	</view>
</template>


<script>
	export default {
		data() {
			return {
				user: {
					username: '',
				},
				newPassword: '',
				confirmPassword: '',
			};
		},
		methods: {
			submit() {
				if (this.newPassword !== this.confirmPassword) {
					this.$u.toast('两次输入的密码不一致');
					return;
				}

				// 更新 user 对象的密码属性
				this.user.password = this.newPassword;

				// 发起网络请求，将新密码发送到后端保存到数据库
				uni.request({
					url: "http://你的后端接口地址", // 替换为实际的后端 API 接口地址
					method: 'POST',
					data: {
						username: this.user.username,
						password: this.newPassword,
					},
					success: (res) => {
						if (res.data.status == 1) { // 根据实际的后端响应结构调整判断条件
							this.$u.toast('密码设置成功');
							// 跳转到登录页面，并将用户名存储在本地存储中以便回显
							uni.setStorageSync("user", this.user);
							uni.navigateTo({
								url: '/pages/login/login'
							});
						} else {
							this.$u.toast('设置密码失败，请重试');
						}
					},
					fail: (err) => {
						this.$u.toast('请求失败，请检查网络连接');
						console.error("请求失败: ", err);
					}
				});
			},
			goback() {
				uni.navigateTo({
					url: '/pages/login/login'
				});
			}
		}
	};
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

	.mimatext {
		width: 100%;
		padding: 39rpx;
		display: flex;
		align-items: center;
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

	// .button {
	// 	position: relative;
	// 	align-self: center;
	// 	margin: 10px;
	// }

	// .section_2 {
	// 	box-shadow: 0rpx 14rpx 34rpx #7033ff33;
	// 	background-image: linear-gradient(89.99999999999999deg, #55aaff 0%, #5a54ff 100%);
	// 	border-radius: 16rpx;
	// 	width: 510rpx;
	// 	height: 96rpx;
	// 	text-align: center;
	// }

	// .pos_3 {
	// 	position: absolute;
	// 	left: 50%;
	// 	top: 50%;
	// 	transform: translate(-50%, -50%);
	// }

	// .text_4 {
	// 	text-transform: uppercase;
	// }

	// .text_12 {
	// 	color: #ffffff;
	// }

	@import "@/css/system.scss";
</style>