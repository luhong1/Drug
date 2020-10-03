package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Drug;
import bean.User;
import utils.DBUtil;
import utils.SqlUtils;

//从数据库调出药品相关信息
public class DrugDaoImpl implements DrugDao{

	Connection conn;
	SqlUtils su = new SqlUtils();
	private Drug drug = new Drug();
	//通过药品编码查询药品
	@Override
	public Drug findDrug(String drugId) {
		
		ResultSet rs = su.query("select * from drug");
		try {
			while(rs.next()){
				String dID = rs.getString("drugID");
				if(drugId.equals(dID)){
					drug.setDrugId(rs.getString("drugID"));
					drug.setDrugName(rs.getString("drugName"));
					drug.setDrugPingyin(rs.getString("drugPingyin"));
					drug.setDrugSpecification(rs.getString("drugSpecification"));
					drug.setDrugUnit(rs.getString("drugUnit"));
					drug.setDrugType(rs.getString("drugType"));
					drug.setDrugPrice(rs.getDouble("drugPrice"));
					drug.setDrugJX(rs.getString("drugJX"));
					drug.setDrugAmount(rs.getInt("drugAmount"));
					return drug;
				}
				
			}System.out.println("对不起没有找到该药品！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return drug;
	}

	@Override
	public void addDrug(Drug drug) {
		try {

			String sql = "select * from drug";
			ResultSet rs = su.query(sql);
			while(rs.next()){
				String dID = rs.getString("drugID");
				if(drug.getDrugId().equals(dID)){
					int a = rs.getInt("drugAmount")+drug.getDrugAmount();
					sql = "UPDATE drug set drugAmount = '"+a+"' WHERE drugID = '"+drug.getDrugId()+"'";
					//result为影响的行数，为0证明添加失败
					int result = su.update(sql);
					if(result>0){
						System.out.println(result);
					}else {
						System.out.println("添加失败");
					}
					return;
				}
			
			}
			sql = "INSERT into drug VALUES ('"+drug.getDrugId()+"','"+drug.getDrugName()+"','"+drug.getDrugPingyin()+
					"','"+drug.getDrugSpecification()+"','"+drug.getDrugUnit()+"','"+drug.getDrugType()+"',"+drug.getDrugPrice()+
					",'"+drug.getDrugJX()+"',"+drug.getDrugAmount()+")";
		
			//result为影响的行数，为0证明添加失败
			
			int result = su.update(sql);
			if(result>0){
				System.out.println(result);
			}else {
				System.out.println("添加失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}		
	}

	@Override
	public void deleteDrug(String drugId) {
		try {

			String sql = "DELETE FROM drug WHERE drugID = '"+drugId+"'";
			//result为影响的行数，为0证明删除失败
			int result = su.update(sql);
			if(result>0){
				System.out.println(result);
			}else {
				System.out.println("删除失败");
			}
		}finally{
			DBUtil.close(conn);
		}			
	}
   //添加药品
	@Override
	public void alterDrug(String drugId,String drugName,String drugPingyin,String drugSpecification,String drugUnit,String drugType,Double drugPrice,String drugPacking,int drugAmount) {//修改
		// TODO Auto-generated method stub
		conn=DBUtil.getConnection();
		try{
			Statement stat=conn.createStatement();
			String sql="update drug set drugID='"+drugId+"',drugName='"+drugName+"',drugPingyin='"+drugPingyin+"',drugSpecification='"+drugSpecification+"',drugUnit='"+drugUnit+"',drugType='"+drugType+"',drugPrice='"+drugPrice+"',drugJX='"+drugPacking+"',drugAmount='"+drugAmount+"' where drugID='"+drugId+"'";
			stat.executeUpdate(sql);
		}catch (SQLException e){
			e.printStackTrace();
		}
		DBUtil.close(conn);
	}
	@Override
	public ArrayList<Drug> findAllDrug() {
		conn=DBUtil.getConnection();
		ArrayList<Drug> info=new ArrayList<>();
		try{
			Statement stat=conn.createStatement();
			String sql="select * from drug";
            ResultSet resultSet = stat.executeQuery(sql);//执行sql，获取结果集
            while(resultSet.next()){ //遍历结果集，取出数据
            	Drug drug=new Drug();
            	drug.setDrugId(resultSet.getString("drugID"));
            	drug.setDrugName(resultSet.getString("drugName"));
            	drug.setDrugPingyin(resultSet.getString("drugPingyin"));
            	drug.setDrugSpecification(resultSet.getString("drugSpecification"));
            	drug.setDrugUnit(resultSet.getString("drugUnit"));
            	drug.setDrugType(resultSet.getString("drugType"));
            	drug.setDrugPrice(resultSet.getDouble("drugPrice"));
            	drug.setDrugPacking(resultSet.getString("drugJX"));
            	drug.setDrugAmount(resultSet.getInt("drugAmount"));
                info.add(drug);
            }
		}catch (SQLException e){
			e.printStackTrace();
		}
		DBUtil.close(conn);
			return info;
	}
	@Override
	public void altreDrug(String drugId,String alter,String alterResult) {
		try {

			String sql = "UPDATE drug set "+alter+" = '"+alterResult+"' WHERE drugID = '"+drugId+"'";
			//result为影响的行数，为0证明删除失败
			int result = su.update(sql);
			if(result>0){
				System.out.println(result);
			}else {
				System.out.println("删除失败");
			}
		}finally{
			DBUtil.close(conn);
		}	
		
	}

	@Override
	public Drug findDrugName(String drugName) {
		ResultSet rs = su.query("select * from drug");
		try {
			while(rs.next()){
				String dName = rs.getString("drugName");
				if(drugName.equals(dName)){
					drug.setDrugId(rs.getString("drugID"));
					drug.setDrugName(rs.getString("drugName"));
					drug.setDrugPingyin(rs.getString("drugPingyin"));
					drug.setDrugSpecification(rs.getString("drugSpecification"));
					drug.setDrugUnit(rs.getString("drugUnit"));
					drug.setDrugType(rs.getString("drugType"));
					drug.setDrugPrice(rs.getDouble("drugPrice"));
					drug.setDrugJX(rs.getString("drugJX"));
					drug.setDrugAmount(rs.getInt("drugAmount"));
					return drug;
				}
				
			}System.out.println("对不起没有找到该药品！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return drug;
	}

	
}
