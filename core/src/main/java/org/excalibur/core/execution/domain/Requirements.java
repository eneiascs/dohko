/**
 *     Copyright (C) 2013-2014  the original author or authors.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License,
 *     any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package org.excalibur.core.execution.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.excalibur.core.cloud.api.Platform;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "requirements")
@XmlType(name="requirements", propOrder= {"numberOfCpuCores_", "memorySize_", "platform_", "maximalCostPerHour_", "numberOfInstancesPerCloud_"})
public class Requirements implements Serializable, Cloneable
{
    /**
     * Serial code version <code>serialVersionUID</code> for serialization.
     */
    private static final long serialVersionUID = -6721150047737841382L;

    @XmlElement(name = "cpu", nillable = false, required = true)
    private Integer numberOfCpuCores_;

    @XmlElement(name = "memory", nillable = false, required = true)
    private Integer memorySize_;

    @XmlElement(name = "platform", nillable = false, required = true)
    private Platform platform_ = Platform.LINUX;

    @XmlElement(name = "cost", nillable = false, required = true)
    private BigDecimal maximalCostPerHour_ = BigDecimal.ONE;
    
    @XmlElement(name = "number-of-instances-per-cloud")
    private Integer numberOfInstancesPerCloud_;
    
    /**
     * @return the numberOfCpuCores
     */
    public Integer getNumberOfCpuCores()
    {
        return numberOfCpuCores_;
    }

    /**
     * @param numberOfCpuCores the numberOfCpuCores to set
     */
    public Requirements setNumberOfCpuCores(Integer numberOfCpuCores)
    {
        this.numberOfCpuCores_ = numberOfCpuCores;
        return this;
    }

    /**
     * @return the memorySize
     */
    public Integer getMemorySize()
    {
        return memorySize_;
    }

    /**
     * @param memorySize the memorySize to set
     */
    public Requirements setMemorySize(Integer memorySize)
    {
        this.memorySize_ = memorySize;
        return this;
    }

    /**
     * @return the platform
     */
    public Platform getPlatform()
    {
        return platform_;
    }

    /**
     * @param platform the platform to set
     */
    public Requirements setPlatform(Platform platform)
    {
        this.platform_ = platform;
        return this;
    }

    /**
     * @return the maximalCostPerHour
     */
    public BigDecimal getMaximalCostPerHour()
    {
        return maximalCostPerHour_;
    }

    /**
     * @param maximalCostPerHour the maximalCostPerHour to set
     */
    public Requirements setMaximalCostPerHour(BigDecimal maximalCostPerHour)
    {
        this.maximalCostPerHour_ = maximalCostPerHour;
        return this;
    }

    /**
     * @return the numberOfInstancesPerCloud
     */
    public Integer getNumberOfInstancesPerCloud()
    {
        return numberOfInstancesPerCloud_;
    }

    /**
     * @param numberOfInstancesPerCloud the numberOfInstancesPerCloud to set
     */
    public Requirements setNumberOfInstancesPerCloud(Integer numberOfInstancesPerCloud)
    {
        this.numberOfInstancesPerCloud_ = numberOfInstancesPerCloud;
        return this;
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(getMaximalCostPerHour(), 
        		                getMemorySize(), 
        		                getNumberOfCpuCores(), 
        		                getPlatform(), 
        		                getNumberOfInstancesPerCloud());
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }

        if (!(obj instanceof Requirements))
        {
            return false;
        }

        Requirements other = (Requirements) obj;

        return Objects.equal(getMaximalCostPerHour(), other.getMaximalCostPerHour()) && 
        	   Objects.equal(getMemorySize(), other.getMemorySize())                 && 
               Objects.equal(getNumberOfCpuCores(), other.getNumberOfCpuCores())     && 
               Objects.equal(getPlatform(), other.getPlatform())                     &&
               Objects.equal(getNumberOfInstancesPerCloud(), other.getNumberOfInstancesPerCloud());
    }

    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this)
                .add("cpu", getNumberOfCpuCores())
                .add("memory",  getMemorySize())
                .add("platform",  getPlatform())
                .add("cost/hour", getMaximalCostPerHour())
                .add("number-of-instances-per-cloud", getNumberOfInstancesPerCloud())
                .omitNullValues()
                .toString();
    }
    
    
    @Override
    public Requirements clone() 
    {
    	Requirements clone;
    	
		try 
		{
			clone = (Requirements) super.clone();
		} 
		catch (CloneNotSupportedException e) 
		{
			clone = new Requirements()
					      .setMaximalCostPerHour(getMaximalCostPerHour())
					      .setMemorySize(getMemorySize())
					      .setNumberOfCpuCores(getNumberOfCpuCores())
					      .setNumberOfInstancesPerCloud(getNumberOfInstancesPerCloud())
					      .setPlatform(getPlatform());
		}
		
    	return clone;
    }

}
