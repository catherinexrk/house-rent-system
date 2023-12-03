package execuate;

import People.Landlord;
import People.RentPeople;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Rentdeal {
    private RentPeople tenant;
    private Landlord landlord;
    private String propertyAddress;
    private double rentAmount;
    private String leaseStartDate;
    private String leaseEndDate;

    public RentDeal(Rentdeal tenant, Landlord landlord, String propertyAddress,
                    double rentAmount, String leaseStartDate, String leaseEndDate) {
        this.tenant = tenant;
        this.landlord = landlord;
        this.propertyAddress = propertyAddress;
        this.rentAmount = rentAmount;
        this.leaseStartDate = leaseStartDate;
        this.leaseEndDate = leaseEndDate;
    }
}

/**
 * 处理环节
 * 大致思路
 * 分为租户、房东两个对象类，一个包
 * 具体功能大致有租户信息录入、租户信息修改、租户信息查询（按照属性细分）
 */
class RentDealManager {
    private List<RentDeal> rentDeals = new ArrayList<>();

    public void addRentDeal(RentDeal rentDeal) {}

    public List<RentDeal> getRentDeals() {}

    public List<RentDeal> findRentDealByTenantId(int tenantId) {}

    public List<RentDeal> findRentDealByLandlordId(int landlordId) {}

    public boolean updateRentAmount(int tenantId, double newRentAmount) {}
}
