package com.example.demomybatis.controller;

import com.example.demomybatis.dao.AssetTypeMapper;
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

    @Autowired
    public AssetController(AssetTypeMapper assetTypeMapper) {
        this.assetTypeMapper = assetTypeMapper;
    }

    //get all asset type
    @GetMapping(path="assetType")
    public List<AssetType> getAllAssetType(@Param("assetType") String assetType,@Param("assetText") String assetText){
        return this.assetTypeMapper.selectByField(assetType,assetText);
    }

    @GetMapping(path="assetType/{id}")
    public AssetType getAssetById(@PathVariable(name="id") String id){
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
}