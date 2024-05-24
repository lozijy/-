<template>
	<view class="container">
		<!-- 顶部  图片及标题-->
		<view class="top">
			<view class="headline">
				<u--text text="添加施肥记录" size=20 color=#000000 align="center" bold=true></u--text>
				<u-line></u-line>
			</view>
		</view>
		<!--中下部分-->
		<view class="buttom">
			<view class="main">
				<view class="Records">
					<u--form labelPosition="left" :model="model1" :rules="rules" ref="uForm">
						<u-form-item label="地块" prop="plot" borderBottom @click="showSheet('plot')">
							<u--input v-model="model1.plot" disabled :disabledColor="'#ffffff'" placeholder="请选择地块"
								border="none"></u--input>
							<u-icon slot="right" name="arrow-right"></u-icon>
						</u-form-item>
						<u-form-item label="种类" prop="tyle" borderBottom @click="showSheet('type')">
							<u--input v-model="model1.tyle" disabled :disabledColor="'#ffffff'" placeholder="请选择种类"
								border="none"></u--input>
							<u-icon slot="right" name="arrow-right"></u-icon>
						</u-form-item>
						<u-form-item label="用量" prop="dosage" borderBottom ref="item1">
							<u--input v-model="model1.dosage" placeholder="用量只能为正数" border="none"></u--input>
						</u-form-item>
						<u-cell-group>
							<u-cell title="施肥日期:" :value="model1.startTime || '请选择施肥日期'" label="" :isLink="true"
								@click="show = true"></u-cell>
						</u-cell-group>
						<u-calendar :show="show" :mode="mode" @confirm="confirm"></u-calendar>
						<u-cell-group>
							<u-cell title="下次施肥日期:" :value="model1.nextTime || '请选择施肥日期'" label="" :isLink="true"
								@click="show2 = true"></u-cell>
						</u-cell-group>
						<u-calendar :show="show2" :mode="mode" @confirm="confirm2"></u-calendar>
						<view>
							<u--textarea v-model="model1.morevaluetxt" placeholder="请输入内容" autoHeight></u--textarea>
						</view>
					</u--form>
					<u-action-sheet :show="showSheetVisible && currentSelection === 'plot'" :actions="actions1"
						title="请选择地块" @close="onSheetClose" @select="onSheetSelect"></u-action-sheet>
					<u-action-sheet :show="showSheetVisible && currentSelection === 'type'" :actions="actions2"
						title="请选择种类" @close="onSheetClose" @select="onSheetSelect"></u-action-sheet>
					</u-action-sheet>

				</view>

			</view>
		</view>
		<view class="buttom-middle">
			<view class="buttom1">
				<u-button class="custom-button" @click="add()">
					<text class="custom-text">确认施肥记录</text>
				</u-button>
			</view>
			<view class="buttom2">
				<u-button class="custom-button" @click="goBack()">
					<text class="custom-text">返回</text>
				</u-button>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				show: false,
				show2: false,
				mode: 'single',
				showSheetVisible: false,
				currentSelection: '', // Tracks which selection is currently shown
				model1: {
					plot: '',
					tyle: '',
					dosage: '1',
					startTime: '', // 施肥时间
					nextTime: '', // 下次施肥时间
					morevaluetxt: '无',
				},
				actions1: [{
					name: '1'
				}, {
					name: '2'
				}], // Example actions for plot
				actions2: [{
					name: '特等'
				}, {
					name: '一等'
				}], // Example actions for type
				rules: {
					'dosage': {
						type: 'string',
						required: true,
						message: '请填写用量',
						trigger: ['blur', 'change']
					},
					'plot': {
						type: 'string',
						required: true,
						message: '请选择地块',
						trigger: ['blur', 'change']
					},
					'tyle': {
						type: 'string',
						required: true,
						message: '请选择种类',
						trigger: ['blur', 'change']
					},
					'time': {
						type: 'string',
						min: 2,
						required: true,
						message: '请选择当前施肥时间',
						trigger: ['change']
					},
				},
			};
		},
		methods: {
			goBack() {
						uni.navigateBack({
							delta: 1 // 这里的数字表示返回的页面层数，1表示返回上一级页面
						});
					},
			add(){
				//添加返回的接口
				
			},
			confirm(e) {
				this.model1.startTime = e[0]; // 直接将选中的日期赋值给model1.startTime
				this.show = false; // 关闭日历
			},
			confirm2(e) {
				this.model1.nextTime = e[0]; // 直接将选中的日期赋值给model1.startTime
				this.show2 = false; // 关闭日历
			},
			showSheet(type) {
				this.currentSelection = type;
				this.showSheetVisible = true;
			},
			onSheetSelect(e) {
				if (this.currentSelection === 'plot') {
					this.model1.plot = e.name;
					this.$refs.uForm.validateField('plot');
				} else if (this.currentSelection === 'type') {
					this.model1.tyle = e.name;
					this.$refs.uForm.validateField('tyle');
				}
				this.showSheetVisible = false;
			},
			onSheetClose() {
				this.showSheetVisible = false;
			},
			hideKeyboard() {
				uni.hideKeyboard()
			},
			calendarConfirm(e) {
				this.showCalendar = false
				this.model1.time = `${e[0]} / ${e[e.length - 1]}`
				this.$refs.form1.validateField('time')
			},
		},
		onReady() {
			this.$refs.uForm.setRules(this.rules);
		},

	};
</script>

<style scoped lang="scss">
	/* 按钮样式 */
	.custom-button {
		position: relative;
		align-self: center;
		margin: 10px;
		box-shadow: 0rpx 14rpx 34rpx #7033ff33;
		background-image: linear-gradient(89.99999999999999deg, #62ff46 0%, #12ac10 100%);
		border-radius: 16rpx;
		width: 510rpx;
		height: 80rpx;
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
.buttom-middle{
	margin-top: 100rpx;
	margin-left: 100rpx;
}
	.container {
		.top {
			.headline {
				margin-top: 10rpx;
			}
		}
	}

	.buttom {
		margin-top: 10rpx;
		width: 100%;
		display: flex;
		justify-content: center;

		.main {
			position: relative;
			width: 700rpx;
			height: 900rpx;
			background-color: #ffffff;
			box-shadow: 0px 0px 9px 0px rgba(10, 53, 74, 0.19);
			border-radius: 10rpx;
			margin-top: 10rpx;
			.Records{
				margin-left: 5rpx;
				margin-right: 5rpx;
			}
		}
	}
</style>