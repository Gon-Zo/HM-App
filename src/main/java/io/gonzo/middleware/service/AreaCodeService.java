package io.gonzo.middleware.service;

import com.opencsv.CSVReader;
import io.gonzo.middleware.enums.AreaCodeTypes;
import io.gonzo.middleware.web.AreaCodeResource;
import io.gonzo.middleware.web.dto.AreaCodeDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static io.gonzo.middleware.enums.AreaCodeTypes.P;

@Service
public class AreaCodeService {

    public List<AreaCodeDTO> getAreaCodeList() {

        List<AreaCodeDTO> areaList = new ArrayList<>();

        InputStream is = AreaCodeResource.class.getResourceAsStream("/area.csv");

        CSVReader reader = new CSVReader(new InputStreamReader(is));

        String[] nextLine;

        try {

            while ((nextLine = reader.readNext()) != null) {

                Integer index = Integer.valueOf(nextLine[0]);
                String code = nextLine[1];
                String title = nextLine[2];
                AreaCodeTypes type = AreaCodeTypes.valueOf(nextLine[3]);
                Integer parentsIndex = Integer.valueOf(nextLine[4]);

                areaList.add(
                        AreaCodeDTO.builder()
                                .index(index)
                                .code(code)
                                .title(title)
                                .type(type)
                                .parentsIndex(parentsIndex)
                                .build()
                );

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return areaList;
    }

    public List<AreaCodeDTO> getAreaCodeToParents() {
        List<AreaCodeDTO> areaList = getAreaCodeList();

        return areaList.stream()
                .filter(area -> P.equals(area.getType()))
                .collect(Collectors.toList());

    }

}
