package com.example.demomybatis.controller;

import com.example.demomybatis.dao.AssetMapper;
import com.example.demomybatis.dao.AssetStatusMapper;
import com.example.demomybatis.dao.AssetTypeMapper;
import com.example.demomybatis.entity.Asset;
import com.example.demomybatis.entity.AssetDetail;
import com.example.demomybatis.entity.AssetStatus;
import com.example.demomybatis.entity.AssetType;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class AssetController {

    private final AssetTypeMapper assetTypeMapper;

    private final AssetMapper assetMapper;

    private final AssetStatusMapper assetStatusMapper;

    @Autowired
    public AssetController(AssetTypeMapper assetTypeMapper, AssetMapper assetMapper, AssetStatusMapper assetStatusMapper) {
        this.assetTypeMapper = assetTypeMapper;
        this.assetMapper = assetMapper;
        this.assetStatusMapper = assetStatusMapper;
    }

    //get all asset type
    @GetMapping(path="assetType")
    public List<AssetType> getAllAssetType(@Param("assetType") String assetType,@Param("assetText") String assetText){
        return this.assetTypeMapper.selectByField(assetType,assetText);
    }

    @GetMapping(path="assetType/{id}")
    public AssetType getAssetTypeById(@PathVariable(name="id") String id){
        return this.assetTypeMapper.selectByPrimaryKey(id);
    }
    @PostMapping(path="assetType")
    public List<AssetType> createAssetType(@RequestBody AssetType assetType){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        assetType.setCreatedBy(username);
        assetType.setCreatedOn(new Date());
        this.assetTypeMapper.insert(assetType);
        return this.assetTypeMapper.selectAll();
//        return String.format("AssetType %s created.",assetType.getAssetType());
    }

    @PutMapping(path="assetType")
    public List<AssetType> updateAssetType(@RequestBody AssetType assetType){
        this.assetTypeMapper.updateByPrimaryKeySelective(assetType);
        return this.assetTypeMapper.selectAll();
    }
    @DeleteMapping(path="assetType/{id}")
    public List<AssetType> deleteAssetType(@PathVariable(name="id") String id){
        this.assetTypeMapper.deleteByPrimaryKey(id);
        return this.assetTypeMapper.selectAll();
    }

    //get all asset
    @GetMapping(path="asset")
    public List<Asset> getAllAsset(@Param("assetId") String assetId, @Param("assetType") String assetTpye){
        return this.assetMapper.selectByField(assetId,assetTpye);
    }

    //asset with status
    @GetMapping(path = "assetDetail")
    public List<AssetDetail> getAssetDetail(@Param("AssetDetail") AssetDetail assetDetail){
        return this.assetMapper.selectAssetDetail(assetDetail);
    }

    @GetMapping(path="asset/{id}")
    public Asset getAssetById(@PathVariable(name="id") String id){
        return this.assetMapper.selectByPrimaryKey(id);
    }
    @PostMapping(path="asset")
    public List<Asset> createAsset(@RequestBody Asset asset){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        asset.setCreatedBy(username);
        asset.setCreatedOn(new Date());
        this.assetMapper.insert(asset);

        //init asset status
        AssetStatus assetStatus = new AssetStatus();
        assetStatus.setAssetId(asset.getAssetId());
        assetStatus.setStatus("1");//Initial status - vehicle available
        assetStatus.setChangedBy(username);
        assetStatus.setChangedOn(new Date());
        this.assetStatusMapper.insert(assetStatus);
        return this.assetMapper.selectAll();
//        return String.format("AssetType %s created.",assetType.getAssetType());
    }

    @PutMapping(path="asset")
    public List<Asset> updateAssetType(@RequestBody Asset asset){

        this.assetMapper.updateByPrimaryKeySelective(asset);
        return this.assetMapper.selectAll();
    }
    @DeleteMapping(path="asset/{id}")
    public List<Asset> deleteAsset(@PathVariable(name="id") String id){
        this.assetMapper.deleteByPrimaryKey(id);
        return this.assetMapper.selectAll();
    }
}