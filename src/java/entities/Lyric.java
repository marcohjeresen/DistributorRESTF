/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author markh
 */
@Entity
@Table(name = "lyric")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lyric.findAll", query = "SELECT l FROM Lyric l"),
    @NamedQuery(name = "Lyric.findByLyId", query = "SELECT l FROM Lyric l WHERE l.lyId = :lyId"),
    @NamedQuery(name = "Lyric.findByLyTitle", query = "SELECT l FROM Lyric l WHERE l.lyTitle = :lyTitle")})
public class Lyric implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ly_id")
    private Integer lyId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ly_title")
    private String lyTitle;
    @Lob
    @Size(max = 65535)
    @Column(name = "ly_text")
    private String lyText;

    public Lyric() {
    }

    public Lyric(Integer lyId) {
        this.lyId = lyId;
    }

    public Lyric(Integer lyId, String lyTitle) {
        this.lyId = lyId;
        this.lyTitle = lyTitle;
    }

    public Integer getLyId() {
        return lyId;
    }

    public void setLyId(Integer lyId) {
        this.lyId = lyId;
    }

    public String getLyTitle() {
        return lyTitle;
    }

    public void setLyTitle(String lyTitle) {
        this.lyTitle = lyTitle;
    }

    public String getLyText() {
        return lyText;
    }

    public void setLyText(String lyText) {
        this.lyText = lyText;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lyId != null ? lyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lyric)) {
            return false;
        }
        Lyric other = (Lyric) object;
        if ((this.lyId == null && other.lyId != null) || (this.lyId != null && !this.lyId.equals(other.lyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Lyric[ lyId=" + lyId + " ]";
    }
    
}
