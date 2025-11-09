/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountDAO;

import AccountDTO.BankAccountDTO;
import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author mahes
 */
public interface BankAccountDAO {
    public boolean insertBankAccountDetails(BankAccountDTO bankAccountDTO);
    public List <BankAccountDTO> getAllAccountHolders();
    public boolean deleteAccountHolder(int accountNumber);
    public BankAccountDTO updateAccountHolder(int accountNumber);   
    public boolean updatedAccountHolderDetails(BankAccountDTO bankAccountDTO);
    
}
