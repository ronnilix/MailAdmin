/*
 * This file is part of MailAdmin.
 *
 *     MailAdmin is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 2 of the License, or
 *     (at your option) any later version.
 *
 *     MailAdmin is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with MailAdmin.  If not, see <http://www.gnu.org/licenses/>.
 */

package de.albritter.sql.data;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by albritter on 04.06.16.
 */
public class Mailbox extends ADataObject {
    @Setter
    protected int active;
    @Setter
    private String username;
    @Setter
    private String domain;
    @Setter
    private String password;
    @Setter
    private String note;
    @Setter
    private int quota;
    @Setter
    private int sendonly;
    @Setter
    @Getter
    private boolean changePassword;

    public String[] getDataAsArray() {
        System.out.println("{SHA512-CRYPT}" + password);
        //return new String[]{username, domain, "{SHA512-CRYPT}" + Sha512Crypt.Sha512_crypt(password, "$6$"+CryptoUtils.getNewSalt()+"$", 5000), String.valueOf(quota), String.valueOf(enabled), String.valueOf(sendonly)};
        if (changePassword)
            return new String[]{username, domain, "{SHA512-CRYPT}" + password, String.valueOf(quota), String.valueOf(active), String.valueOf(sendonly), note};

        return new String[]{username, domain, String.valueOf(quota), String.valueOf(active), String.valueOf(sendonly), note};
    }
}
