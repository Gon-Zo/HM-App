package io.gonzo.middleware.web;

import io.gonzo.middleware.service.AreaCodeService;
import io.gonzo.middleware.web.dto.AreaCodeDTO;
import io.gonzo.middleware.web.dto.AreaCodeStoreDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static io.gonzo.middleware.enums.AreaCodeTypes.P;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/area-code")
public class AreaCodeResource {

    private final AreaCodeService service;

    /**
     * 직역 코드 api
     * @return
     */
    @GetMapping("")
    public List<AreaCodeStoreDTO> showAreaList() {

        List<AreaCodeDTO> areaList = service.getAreaCodeList();

        return areaList.stream()
                .filter(area -> P.equals(area.getType()))
                .map(parents -> {

                    Integer index = parents.getIndex();

                    List<AreaCodeDTO> childList = areaList.stream()
                            .filter(child -> child.getParentsIndex().equals(index))
                            .collect(Collectors.toList());

                    return AreaCodeStoreDTO.builder()
                            .index(index)
                            .code(parents.getCode())
                            .title(parents.getTitle())
                            .parentsIndex(parents.getParentsIndex())
                            .type(parents.getType())
                            .childList(childList)
                            .build();
                })
                .collect(Collectors.toList());

    }

}
