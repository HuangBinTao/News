package component;

import java.sql.SQLException;

public interface JFAction {

		//初始化
		public void init();
		//创建组件
		public void createComponent() throws SQLException;
		//添加组件进jf中
		public void addComonent();
		//设置组件的位置和大小
		public void setLocate();
		//为组件添加事件
		public void addListener();
}
